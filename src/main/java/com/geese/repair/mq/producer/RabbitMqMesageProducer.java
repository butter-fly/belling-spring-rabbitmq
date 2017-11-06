package com.geese.repair.mq.producer;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.geese.repair.mq.MesageProducer;
import com.geese.repair.mq.common.MessageResponse;

/**  
 * @Description	RabbtMq消息生成者
 * @author		buffter-fly
 * @date	    2017年9月26日 下午6:40:59  
 */  
public class RabbitMqMesageProducer extends MesageProducer {
	
	/**
	 * 日志对象
	 */
	private static final Logger logger = LoggerFactory.getLogger(RabbitMqMesageProducer.class);
	
	/**
	 * 普通消息模板对象
	 */
	@Autowired  
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * 延迟消息模板对象
	 */
	@Autowired  
	private RabbitTemplate rabbitTemplate2;
	
	/**
	 * @Description 消息同步发送
	 * 
	 * @author buffter-fly
	 * @date 2017年9月27日 上午9:11:52 
	 * @param routingKey 路由键
	 * @param message 消息体
	 * @return MessageResponse
	 */
	@Override
	public MessageResponse send(final String routingKey, final Object message) {
		MessageResponse messageResponse = new MessageResponse();
		try {
			rabbitTemplate.convertAndSend(routingKey, message);
			messageResponse.setRet(true);
			messageResponse.setMsg("消息发送成功");
		} catch (Exception e) {
			logger.warn("send to mq failed", e);
			messageResponse.setRet(false);
			messageResponse.setMsg("消息发送失败");
		}
		return messageResponse;
	}
	
	/**
	 * @Description 消息延时发送 
	 * 
	 * @author buffter-fly
	 * @date 2017年9月27日 上午9:12:06 
	 * @param routingKey 路由键
	 * @param message 消息体
	 * @param delayTime 延迟时间 单位秒
	 * @return MessageResponse
	 */
	@Override
	public MessageResponse sendDelay(final String routingKey, final Object message, final int delayTime) {
		MessageResponse messageResponse = new MessageResponse();
		final int xdelay = delayTime * 1000;
		try {
			rabbitTemplate2.convertAndSend(routingKey, message, new MessagePostProcessor() {
				@Override
				public Message postProcessMessage(Message message) throws AmqpException {
					//设置消息持久化
					message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
					 //设置延迟时间
					message.getMessageProperties().setDelay(xdelay);
					return message;
				}
			});
			
			messageResponse.setRet(true);
			messageResponse.setMsg("消息发送成功");
		} catch (Exception e) {
			logger.warn("Delay send to mq failed", e);
			messageResponse.setRet(false);
			messageResponse.setMsg("消息发送失败");
		}
		return messageResponse;
	}
	
	/**
	 * @Description 消息定时发送
	 * 
	 * @author buffter-fly
	 * @date 2017年9月28日 下午3:41:19 
	 * @param routingKey 路由键
	 * @param message 消息体
	 * @param timingDate 定时时间
	 * @return MessageResponse
	 */
	@Override
	public MessageResponse sendTiming(String routingKey, Object message, Date timingDate) {
		MessageResponse messageResponse = new MessageResponse();
		try {
			Date nowDate = new Date();
			if (null == timingDate || timingDate.compareTo(nowDate) <= 0) {
				rabbitTemplate2.convertAndSend(routingKey, message);
				messageResponse.setRet(true);
				messageResponse.setMsg("消息发送成功");
				return messageResponse;
			}
			
			// 计算时间差 单位为秒
			final long xdelay = timingDate.getTime() - nowDate.getTime();
			rabbitTemplate2.convertAndSend(routingKey, message, new MessagePostProcessor() {
				@Override
				public Message postProcessMessage(Message message) throws AmqpException {
					//设置消息持久化
					message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
					 //设置延迟时间
					message.getMessageProperties().setDelay((int)xdelay);
					return message;
				}
			});
			
			messageResponse.setRet(true);
			messageResponse.setMsg("消息发送成功");
		} catch (Exception e) {
			logger.warn("Timing send to mq failed", e);
			messageResponse.setRet(false);
			messageResponse.setMsg("消息发送失败");
		}
		return messageResponse;
	}
}

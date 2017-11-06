package com.geese.repair.mq;

import java.util.Date;

import com.geese.repair.mq.common.MessageResponse;


/**  
 * @Description	抽象消息生产对象
 * @author		buffter-fly
 * @date	    2017年9月26日 下午5:43:58  
 */  
public abstract class MesageProducer {
	
	/**
	 * @Description 消息同步发送
	 * 
	 * @author buffter-fly
	 * @date 2017年9月27日 上午9:11:52 
	 * @param routingKey 路由键
	 * @param message 消息体
	 * @return MessageResponse
	 */
	public abstract MessageResponse send(String routingKey, Object message);
	
	
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
	public abstract MessageResponse sendDelay(String routingKey, Object message, int delayTime);
	
	
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
	public abstract MessageResponse sendTiming(String routingKey, Object message, Date timingDate);
}

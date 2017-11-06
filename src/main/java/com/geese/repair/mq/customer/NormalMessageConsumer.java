package com.geese.repair.mq.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.geese.repair.mq.common.EventMessage;
import com.geese.repair.tools.ObjectAndByteCovertUtil;
import com.geese.repair.tools.TimeUtils;
import com.rabbitmq.client.Channel;

/**
 * @Description 普通消息消费者
 * @author buffter-fly
 * @date 2017年9月29日 下午13:48:57
 */
public class NormalMessageConsumer implements ChannelAwareMessageListener {

	/**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(NormalMessageConsumer.class);

	/**
	 * 普通消息监听
	 * 
	 * @param message 消息实体
	 * @param channel channel 就是当前的会话通道
	 * @throws Exception 备注： 手动ack就是在当前channel里面调用basicAsk的方法，并传入当前消息的tagId就可以了。
	 */
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		logger.debug("deliveryTag= " + deliveryTag);
		try {
			logger.info("------消费者处理消息------");
			logger.info("receive message" + message.getMessageProperties().getAppId());
			logger.info("receive channel" + channel.getChannelNumber() + "----");
			// 获取消息
			if (null != message.getBody()) {
				EventMessage eventMessage = (EventMessage) ObjectAndByteCovertUtil.ByteToObject(message.getBody());
				if (null != eventMessage) {
					System.out.println(Thread.currentThread().getName() + ":" +  TimeUtils.getSysTime("yyyy-MM-dd HH:mm:ss") + "：[下游应用- 消费普通消息]：" + message.getMessageProperties());
					// TODO 业务处理
				}
			}
			// 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息（成功消费，消息从队列中删除 ）
			channel.basicAck(deliveryTag, false);
		} catch (Exception e) {
			logger.warn("message consume failed: " + e.getMessage());
			// ack返回false，requeue-true并重新回到队列
			channel.basicNack(deliveryTag, false, true);
		}
	}
}
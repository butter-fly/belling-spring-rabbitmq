package com.geese.repair.mq.common;

 
/**  
 * @Description	消息常量
 * @author		buffter-fly
 * @date	    2017年9月26日 下午5:49:06  
 */  
public final class RabbitMQConstant {
	
	/**
	 * 私有化
	 */
	private RabbitMQConstant() {}
	
	/**
	 * 微信订单提醒队列routingKey
	 */
	public static final String WECHAT_MSG_NOTIFY_QUEUE_ROUTING_KEY = "queue.wechat.notify";
	
	/**
	 *  工单延迟提醒队列routingKey
	 */
	public static final String DELAY_MSG_NOTIFY_QUEUE_ROUTING_KEY = "queue.work.order.delay.notify";
}

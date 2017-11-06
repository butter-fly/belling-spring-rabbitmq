package com.geese.repair.mq.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**  
 * @Description	消息确认回调函数
 * @author		buffter-fly
 * @date	    2017年9月30日 上午9:23:42  
 */
public class ConfirmCallBackListener implements ConfirmCallback {

	/* (non-Javadoc)
	 * @see org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback#confirm(org.springframework.amqp.rabbit.support.CorrelationData, boolean, java.lang.String)
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("confirm--:correlationData:"+correlationData+",ack:"+ack+",cause:"+cause);
	}
}

package com.geese.repair.mq.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

/**  
 * @Description	消费类专门用来处理错误异常的消息
 * @author		buffter-fly
 * @date	    2017年9月28日 下午3:31:16  
 */

public class MessageErrorHandler implements ErrorHandler {
	
	/**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageErrorHandler.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.util.ErrorHandler#handleError(java.lang.Throwable)
	 */
	@Override
	public void handleError(Throwable t) {
		logger.error("RabbitMQ happen a error:" + t.getMessage(), t);  
	}
}

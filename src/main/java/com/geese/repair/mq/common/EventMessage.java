package com.geese.repair.mq.common;

import java.io.Serializable;

/**  
 * @Description	传递消息对象
 * @author		buffter-fly
 * @date	    2017年9月28日 下午2:34:42  
 */

public class EventMessage implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 2559157945573355540L;
	
	/**
	 * 消息类型
	 */
	private String type; 
	
	/**
	 * 消息对象
	 */
	private Object object;
	

	/**
	 * 无惨构造
	 */
	public EventMessage() {
		super();
	}

	/**
	 * @param type
	 * @param object
	 */
	public EventMessage(String type, Object object) {
		super();
		this.type = type;
		this.object = object;
	}

	/**
	 * @return the {@link #type}
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the {@link #type} to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the {@link #object}
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object the {@link #object} to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
}

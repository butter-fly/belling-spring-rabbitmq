package com.geese.repair.mq.common;

/**  
 * @Description	统一返回值,可描述失败细节
 * @author		buffter-fly
 * @date	    2017年9月26日 下午5:46:52  
 */  
public class MessageResponse {
	
	/**
	 * 是否成功 false-失败 true-成功
	 */
	private boolean ret = false;
	
	/**
	 * 响应信息
	 */
	private String msg;

	/**
	 * @return the {@link #ret}
	 */
	public boolean isRet() {
		return ret;
	}

	/**
	 * @param ret the {@link #ret} to set
	 */
	public void setRet(boolean ret) {
		this.ret = ret;
	}

	/**
	 * @return the {@link #msg}
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the {@link #msg} to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}

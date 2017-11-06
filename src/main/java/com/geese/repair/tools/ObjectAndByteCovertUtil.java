package com.geese.repair.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**  
 * @Description	对象和字节转换工具类
 * @author		buffter-fly
 * @date	    2017年9月28日 下午2:29:24  
 */  
public final class ObjectAndByteCovertUtil {
	
	
	/**
	 * @Description 字节数组转对象
	 * 
	 * @author buffter-fly
	 * @date 2017年9月28日 下午2:29:16 
	 * @param bytes
	 * @return
	 */
	public static Object ByteToObject(byte[] bytes) {
		Object obj = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			// bytearray to object
			bi = new ByteArrayInputStream(bytes);
			oi = new ObjectInputStream(bi);
			obj = oi.readObject();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != bi)
				try {
					bi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			if (null != oi)
				try {
					oi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return obj;
	}

	
	/**
	 * @Description 对象转字节数组
	 * 
	 * @author buffter-fly
	 * @date 2017年9月28日 下午2:29:50 
	 * @param obj
	 * @return
	 */
	public static byte[] ObjectToByte(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			// object to bytearray
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			bytes = bo.toByteArray();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != bo) {
				try {
					bo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != oo) {
				try {
					oo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bytes;
	}
}

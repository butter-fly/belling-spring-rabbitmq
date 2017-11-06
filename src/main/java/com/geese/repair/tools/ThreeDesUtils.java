package com.geese.repair.tools;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**  
 * @Description	3DES加密工具类
 * @author		buffter-fly
 * @date	    2017年10月9日 上午9:16:06  
 */  
public final class ThreeDesUtils {
	
	/**
	 * 加密向量
	 */
	private final static String iv = "01234567";
	
	/**
	 * 加解密统一使用的编码方式
	 */
	private final static String encoding = "utf-8";
	
	/**
	 * 3DES加密
	 * 
	 * @param plainText 普通文本 pk 密钥
	 * @return 加密的结果
	 * @throws Exception 
	 */
	public static String desEncode(String plainText,String pk) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(pk.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Bytes2HexString(encryptData);
	}

	/**
	 * 3DES解密
	 * 
	 * @param encryptText 加密文本 pk 密钥
	 * @return 解密的结果
	 * @throws Exception
	 */
	public static String desDecode(String encryptText, String pk) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(pk.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] decryptData = cipher.doFinal(hexStringToBytes(encryptText));
		return new String(decryptData, encoding);
	}

	private static String Bytes2HexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}

	private static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
}

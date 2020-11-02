package com.asdcce.ddgfd.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ToolMD5 {

	public static String getMD5Str(String inputStr) {
		return getMD5Str(inputStr, false);
	}

	/**
	 * md5加密
	 * @param flag 大小写
	 * @return
	 */
	public static String getMD5Str(String inputStr, boolean flag) {
		if (inputStr == null) return "";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(inputStr.getBytes("utf-8"));
			byte messageDigest[] = digest.digest();
			String outputStr = toHexString(messageDigest);
			if (flag == true) {
				outputStr = outputStr.toUpperCase();
			}
			return outputStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStr;
	}

	private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public static String toHexString(byte[] b) { // String to byte
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return sb.toString();
	}
}

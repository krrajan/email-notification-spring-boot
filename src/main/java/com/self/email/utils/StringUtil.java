package com.self.email.utils;

public interface StringUtil {

	public static boolean isNull(String text) {
		if (null != text) {
			return true;
		}
		return false;
	}
}

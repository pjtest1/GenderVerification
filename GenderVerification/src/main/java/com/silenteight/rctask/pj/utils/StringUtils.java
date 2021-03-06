package com.silenteight.rctask.pj.utils;

public class StringUtils {

	public static String trim(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("(^\\s+)|(\\s+$)", "");
	}

	public static String capitalize(String str) {
		if (str == null) {
			return null;
		}

		if (str.length() > 0) {
			str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
		}

		return str;
	}

}

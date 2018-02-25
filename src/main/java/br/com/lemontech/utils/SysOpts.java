package br.com.lemontech.utils;

public class SysOpts {
	public static String env(String key, String def) {
		String tmp = System.getenv(key);
		if (tmp == null || tmp.equals(""))
			return def;
		
		return tmp;
	}
}

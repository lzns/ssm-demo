package com.dzf.utils;

import com.dzf.shiro.PasswordHash;

public class AlgorithmUtil {

	public static String alogrithm(Object source,Object salt){
		PasswordHash p = new PasswordHash();
		p.setHashAlgorithm("md5");
		p.setHashIterations(2);
		String hex = p.toHex(source, salt);
		return hex;
	}
	public static void main(String[] args) {
		String str = alogrithm("1234","###");
		System.out.println(str);
	}
}


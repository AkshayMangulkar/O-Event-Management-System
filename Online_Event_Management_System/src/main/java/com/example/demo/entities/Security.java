package com.example.demo.entities;

public class Security {
	public static String PasswordEncription(String pass) {
		String result="";
		for(int i=0;i<pass.length();i++) {
			result+=pass.charAt(i)+5;
		}
		return result;
	}

}

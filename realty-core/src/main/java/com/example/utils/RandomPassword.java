package com.example.utils;

public class RandomPassword {

	public static String passWordRandom() {
		String result = makePassword(8);
		return result;
	}
	public static String makePassword(int lenght) {
		
		String passWord = "";
		for(int i=0;i<lenght-2;i++) {
			passWord = passWord + randomCharacter("abcdefghiklmnopqrstuvwxyz");
		}
		String radomDigit = randomCharacter("0123456789");
		passWord = insertAtRanDom(passWord,radomDigit);
		return passWord;
	}
	
	private static String insertAtRanDom(String passWord, String radomDigit) {
		int n = passWord.length();
		int r = (int) ((n+1) * Math.random());
		return passWord.substring(0, r) + radomDigit + passWord.substring(r);
	}
	public static String randomCharacter(String charater) {
		int n = charater.length();
		int r = (int) (n*Math.random());
		return charater.substring(r, r+1);
		
	}
}

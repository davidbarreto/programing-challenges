package br.com.dbarreto.challenge.misc;

public class BinaryStringAddition {

	public String add(String a, String b) {
		
		int size = Math.max(a.length(), b.length());
		int i = a.length() - 1;
		int j = b.length() - 1;
		char[] arr = new char[size];
		
		char rest = '0';
		for (int k = size-1; k >= 0; k--) {
			
			char digit1 = '0';
			char digit2 = '0';
			
			if (i >= 0) {
				digit1 = a.charAt(i--);
			}
			
			if (j >= 0) {
				digit2 = b.charAt(j--);
			}
			
			char[] s = sum(digit1, digit2, rest);
			rest = s[1];
			arr[k] = s[0];
		}
		
		String res = String.valueOf(arr);
		if (rest == '1') {
			res = "1" + res;
		}
		
		return res;
	}
	
	private char[] sum(char bit1, char bit2, char rest) {
		
		char bit = '0';
		
		if (rest == '1') {
			if (bit1 == '1' && bit2 == '1') {
				bit = '1';
				rest = '1';
			} else if (bit1 == '0' && bit2 == '0') {
				bit = '1';
				rest = '0';
			} else {
				bit = '0';
				rest = '1';
			}
		} else {
			if (bit1 == '1' && bit2 == '1') {
				bit = '0';
				rest = '1';
			} else if (bit1 == '0' && bit2 == '0') {
				bit = '0';
				rest = '0';
			} else {
				bit = '1';
				rest = '0';
			}
		}
		
		char[] ans = new char[2];
		ans[0] = bit;
		ans[1] = rest;
		return ans;
	}
}

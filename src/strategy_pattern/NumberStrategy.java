package strategy_pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberStrategy implements CryptoStrategy {
	private String cryptPattern;

	@Override
	public String encrypt(String s) {
		try {
			readCryptPattern();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		char[] a = s.toLowerCase().toCharArray();
		String encrypted = "";
		for(char c : a) {
			encrypted += (encryptOneChar(c) + " ");
		}
		return encrypted;
	}

	@Override
	public String decrypt(String s) {
		try {
			readCryptPattern();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] numbers = s.split(" ");
		String decrypted = "";
		for(String number : numbers) {
			decrypted += decryptOneNumber(number);
		}
		return decrypted;
	}
	
	private String encryptOneChar(char c) {
		String[] lines = cryptPattern.split("\n");
		for(String str : lines) {
			if(str.startsWith("" + c)) {
				String[] s = str.split(":");
				return s[1];
			}
		}
		return null;
	}
	
	private String decryptOneNumber(String c) {
		String[] lines = cryptPattern.split("\n");
		for(String str : lines) {
			if(str.endsWith(c)) {
				String[] s = str.split(":");
				return s[0];
			}
		}
		return null;
	}
	
	private void readCryptPattern() throws FileNotFoundException {
		Scanner s = new Scanner(new File("src/strategy_pattern/number_pattern.txt"));
		String str = "";
		while(s.hasNext()) {
			str += s.nextLine() + "\n";
		}
		cryptPattern = str;
	}
	
}

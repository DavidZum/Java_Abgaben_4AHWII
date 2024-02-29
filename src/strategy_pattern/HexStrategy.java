package strategy_pattern;

public class HexStrategy implements CryptoStrategy {

	@Override
	public String encrypt(String s) {
		String hex = "";
		char[] a = s.toCharArray();
		for(char c : a) {
			hex += Integer.toHexString(c) + " ";
		}
		return hex;
	}

	@Override
	public String decrypt(String s) {
		String[] numbers = s.split(" ");
		String text = "";
		for(String str : numbers) {
			text += (char) Integer.parseInt(str, 16);
		}
		return text;
	}
}

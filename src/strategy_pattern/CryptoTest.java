package strategy_pattern;

import java.io.IOException;

public class CryptoTest {
	
	private static String path = "src/strategy_pattern/test.txt";

	public static void main(String[] args) throws IOException {
		CryptIO crypt = new CryptIO("Test", new HexStrategy());
		crypt.write(path);
		crypt.read(path);
		System.out.println(crypt.getText());
	}
}

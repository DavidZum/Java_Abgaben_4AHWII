package strategy_pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CryptIO {

	public CryptIO(String text, CryptoStrategy strat) {
		this.text = text;
		this.strat = strat;
	}

	private String text;
	private CryptoStrategy strat;

	public void write(String fPath) throws IOException {
		FileWriter fw = new FileWriter(new File(fPath));
		String encrypted = strat.encrypt(this.text);
		fw.write(encrypted);
		fw.close();
	}

	public void read(String fPath) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fPath));
		String encrypted = "";
		while (s.hasNextLine()) {
			encrypted += s.nextLine();
		}
		this.text = strat.decrypt(encrypted);
		s.close();
	}

	public String getText() {
		return text;
	}

	public void setCryptoStrategy(CryptoStrategy strat) {
		this.strat = strat;
	}

}

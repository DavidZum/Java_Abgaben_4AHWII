package strategy_pattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Caesar_ChiffreTest {

	@Test
	void testEncrypt() {
		Caesar_Chiffre strat = new Caesar_Chiffre(3);
		String value = "esxcdrztgbzhnujijjrxestcdzvfugbihnuomjpkolrftgzhuijokzguhfgzugtzghugzfvgjnjngz";
		String encrypted = strat.encrypt(value);
		assertEquals(value, strat.decrypt(encrypted));
	}

}

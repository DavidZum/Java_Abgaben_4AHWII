package strategy_pattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

class HexStrategyTest {

	@RepeatedTest(value = 1000)
	void testEncrypt() {
		HexStrategy strat = new HexStrategy();
		String value = "";
		for (int i = 0; i < 100; i++) {
			value += (char) (Math.random() * 100);
		}
		String encrypted = strat.encrypt(value);
		assertEquals(value, strat.decrypt(encrypted));
	}
}

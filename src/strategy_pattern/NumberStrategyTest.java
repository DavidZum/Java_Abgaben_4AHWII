package strategy_pattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberStrategyTest {

	@Test
	void testEncrypt() {
		NumberStrategy strat = new NumberStrategy();
		String value = "djhgpidsufjkhvsofuzdijkhbgfosuzjmbfdukghjbgfdguhbjmgfdugdhf";
		value.toLowerCase();
		String encrypted = strat.encrypt(value);
		assertEquals(value, strat.decrypt(encrypted));
	}
}

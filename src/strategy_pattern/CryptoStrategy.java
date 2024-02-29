package strategy_pattern;

public interface CryptoStrategy {

	public String encrypt(String s);

	public String decrypt(String s);
}

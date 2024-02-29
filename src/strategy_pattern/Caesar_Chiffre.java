package strategy_pattern;

public class Caesar_Chiffre implements CryptoStrategy {
    
    private int verschiebung;
    
    public Caesar_Chiffre(int verschiebung) {
        this.verschiebung = verschiebung;
    }

    @Override
    public String encrypt(String s) {
        char[] a = s.toCharArray();
        StringBuilder encrypted = new StringBuilder();
        for (char c : a) {
            if (Character.isLetter(c)) {
                char shifted = (char) ((c - 'a' + verschiebung) % 26 + 'a');
                encrypted.append(shifted);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt(String s) {
        char[] a = s.toCharArray();
        StringBuilder decrypted = new StringBuilder();
        for (char c : a) {
            if (Character.isLetter(c)) {
                char shifted = (char) ((c - 'a' - verschiebung + 26) % 26 + 'a');
                decrypted.append(shifted);
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}

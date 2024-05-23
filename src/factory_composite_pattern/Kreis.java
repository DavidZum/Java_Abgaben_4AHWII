package factory_composite_pattern;

import java.awt.Graphics;

public class Kreis extends Figur {
	
	private int r;
	
	public Kreis(int posX, int posY, int r) {
		this.posX = posX;
		this.posY = posY;
		this.r = r;
	}

	@Override
	public void paint(Graphics g) {
		g.drawOval(posX, posY, r, r);
	}

	@Override
	public String toString() {
		return "Kreis [r=" + r + ", posX=" + posX + ", posY=" + posY +"]";
	}

}

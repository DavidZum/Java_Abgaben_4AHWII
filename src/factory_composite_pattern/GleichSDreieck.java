package factory_composite_pattern;

import java.awt.Graphics;

public class GleichSDreieck extends Figur {

	
	private int s;
	
	public GleichSDreieck(int posX, int posY, int r) {
		this.posX = posX;
		this.posY = posY;
		this.s = r;
	}

	@Override
	public void paint(Graphics g) {
	    int[] xPoints = { posX, posX + s, posX + s / 2 };
	    int[] yPoints = { posY + s, posY + s, posY };

	    g.drawPolygon(xPoints, yPoints, 3);
	}

	@Override
	public String toString() {
		return "GleichSDreieck [r=" + s + ", posX=" + posX + ", posY=" + posY +"]";
	}

}

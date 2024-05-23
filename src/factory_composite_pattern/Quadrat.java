package factory_composite_pattern;

import java.awt.Graphics;

public class Quadrat extends Figur {
	
	private int l;
	
	public Quadrat(int posX, int posY, int l) {
		this.posX = posX;
		this.posY = posY;
		this.l = l;
	}

	@Override
	public void paint(Graphics g) {
		g.drawRect(posX, posY, l, l);
	}

	@Override
	public String toString() {
		return "Quadrat [l=" + l + ", posX=" + posX + ", posY=" + posY +"]";
	}


	

}

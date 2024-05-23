package factory_composite_pattern;

import java.awt.Graphics;

public abstract class Figur {
	protected int posX;
	protected int posY;
	private String name;
	
	public Figur() {
		
	}

	public abstract void paint(Graphics g);
}

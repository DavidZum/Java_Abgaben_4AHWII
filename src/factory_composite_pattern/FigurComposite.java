package factory_composite_pattern;

import java.awt.Graphics;
import java.util.ArrayList;

public class FigurComposite extends Figur {
	
	private ArrayList<Figur> figuren;
	
	public FigurComposite(int posX, int posY, ArrayList<Figur> figuren) {
		this.posX = posX;
		this.posY = posY;
		this.figuren = figuren;
	}
	
	public void add(Figur f) {
		figuren.add(f);
	}

	@Override
	public void paint(Graphics g) {
		for (Figur figur : figuren) {
			figur.paint(g);
		}
	}

}

package factory_composite_pattern;

import java.util.ArrayList;
import java.util.HashMap;

public class FigurFactory {

	public static Figur create(String type, String pars, HashMap<String, Figur> figuren) {
		switch (type) {
		case "quadrat":
			String[] params = pars.split(";");
			Quadrat q = new Quadrat(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
			figuren.put(params[3], q);
			return q;
		case "kreis":
			params = pars.split(";");
			Kreis k = new Kreis(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
			figuren.put(params[3], k);
			return k;
		case "dreieck":
			params = pars.split(";");
			GleichSDreieck d = new GleichSDreieck(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
			figuren.put(params[3], d);
			return d;
		case "composite":
			params = pars.split(";");
			ArrayList<Figur> composite = new ArrayList<>();
			for(int i = 0; i < params.length - 1; i++) {
				composite.add(figuren.get(params[i]));
			}
			FigurComposite c = new FigurComposite(composite.get(0).posX, composite.get(0).posX, composite);
			figuren.put(params[params.length - 1], c);
			
		}

		return null;
	}

}

package factory_composite_pattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PaintFrame extends JFrame implements ActionListener {
	
	private Container c;
	private HashMap<String, Figur> figuren;
	private TextField tf;
	
	public PaintFrame(String title) {
		super(title);
		figuren = new HashMap<>();

		this.setSize(1920, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		JButton add = new JButton("hinzufügen");
		add.addActionListener(this);
		tf = new TextField();
		tf.setPreferredSize(new Dimension(400, 25));
		JPanel input = new JPanel();
		
		input.add(tf);
		input.add(add);
		
		c = new Container();
		c.setBackground(Color.GREEN);
		this.add(input, BorderLayout.NORTH);
		this.add(c, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = tf.getText();
		String[] params = input.split(";");
		String pars = "";
		for(int i = 1; i < params.length; i++) {
			pars += params[i];
			pars += ";";
		}
		String type = params[0];
		FigurFactory.create(type, pars, figuren);
		tf.setText("");
		repaint(c.getGraphics());
	}
	
	public void repaint(Graphics g) {
		figuren.forEach((key, figur) -> {
			figur.paint(g);
		});
	}

	public static void main(String[] args) {
		PaintFrame pf = new PaintFrame("Paint");
	}
}

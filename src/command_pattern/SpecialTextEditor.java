package command_pattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SpecialTextEditor extends JFrame {

	public SpecialTextEditor(String title) {
		super(title);
	}
	
	private static CommandHandler ch = new CommandHandler();
	private static String oldText = "";
	
	public static void main(String[] args) {
		SpecialTextEditor ed = new SpecialTextEditor("Special Text Editor");

		ed.setSize(1920, 1080);
		ed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ed.setLocationRelativeTo(null);
		ed.setVisible(true);
		JEditorPane html = new JEditorPane();
		JEditorPane editor = new JEditorPane();
		html.setContentType("text/plain");
		html.setBorder(BorderFactory.createLineBorder(Color.black));
		html.setPreferredSize(new Dimension(700,600));
		
		html.setText("<html>\n<head>\n\n</head>\n<body>\n\n</body>\n</html>");
		html.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				String currentText = html.getText();
				KeyCommand com = new KeyCommand(oldText, currentText, editor, html);
				ch.ausfuehren(com);
				oldText = currentText;
			}
		});
		editor.setContentType("text/html");
		editor.setBorder(BorderFactory.createLineBorder(Color.black));
		editor.setPreferredSize(new Dimension(700,600));
		
		
		ed.setLayout(new BorderLayout());
		ed.add(editor, BorderLayout.WEST);
		ed.add(html, BorderLayout.EAST);
		
		JButton remove = new JButton("remove");
		remove.addActionListener((ActionEvent) -> {
			KeyCommand com = new KeyCommand(oldText, "", editor, html);
			ch.ausfuehren(com);
		});
		
		JButton undo = new JButton("undo");
		undo.addActionListener((ActionEvent) -> {
			ch.undo();
		});
		
		JButton redo = new JButton("redo");
		redo.addActionListener((ActionEvent) -> {
			ch.redo();
		});
		
		JPanel buttons = new JPanel();
		buttons.add(remove);
		buttons.add(undo);
		buttons.add(redo);
		
		ed.add(buttons, BorderLayout.NORTH);
		
		
	}
}

package command_pattern;

import javax.swing.JEditorPane;

public class KeyCommand implements CommandInterface {
	private String oldText;
	private String newText;
	private JEditorPane editor;
	private JEditorPane html;
	


	public KeyCommand(String oldText, String newText, JEditorPane editor, JEditorPane html) {
		super();
		this.oldText = oldText;
		this.newText = newText;
		this.editor = editor;
		this.html = html;
	}

	public void ausfuehren() {
		if(!html.getText().equals(newText)) {
			html.setText(newText);
		}
		editor.setText(newText);
	}

	public void rueckgaengig() {
		editor.setText(oldText);
		html.setText(oldText);
	}

}

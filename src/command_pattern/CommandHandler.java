package command_pattern;

import java.util.Stack;

public class CommandHandler {

	public CommandHandler() {

	}

	private Stack<CommandInterface> undo = new Stack<CommandInterface>();
	private Stack<CommandInterface> redo = new Stack<CommandInterface>();

	public void ausfuehren(CommandInterface ci) {
		ci.ausfuehren();
		undo.push(ci);
	}

	public void undo() {
		if (!undo.empty()) {

			CommandInterface ci = undo.pop();
			redo.push(ci);
			ci.rueckgaengig();
		}
	}

	public void redo() {
		if (!redo.empty()) {
			CommandInterface ci = redo.pop();
			undo.push(ci);
			ci.ausfuehren();
		}
	}
}

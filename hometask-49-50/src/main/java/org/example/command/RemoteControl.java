package org.example.command;

import org.example.command.interfaces.Command;
import org.example.command.interfaces.UndoableCommand;

import java.util.Stack;

public class RemoteControl {
    private Command command;
    private Stack<UndoableCommand> history = new Stack<>();

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        if (command instanceof UndoableCommand) {
            history.push((UndoableCommand) command);
        }
    }

    public void pressUndo() {
        if (!history.isEmpty()) {
            UndoableCommand lastCommand = history.pop();
            lastCommand.undo();
        }
    }

    public void removeLastCommand() {
        if (!history.isEmpty()) {
            history.pop();
        }
    }
}

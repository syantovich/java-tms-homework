package org.example.command.commands;

import org.example.command.Light;
import org.example.command.interfaces.UndoableCommand;

public class TurnOnLightCommand implements UndoableCommand {
    private final Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

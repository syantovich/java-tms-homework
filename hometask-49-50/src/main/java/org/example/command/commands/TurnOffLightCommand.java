package org.example.command.commands;

import org.example.command.Light;
import org.example.command.interfaces.UndoableCommand;

public class TurnOffLightCommand implements UndoableCommand {
    private final Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

package org.example.command;

import org.example.command.commands.TurnOffLightCommand;
import org.example.command.commands.TurnOnLightCommand;
import org.example.command.interfaces.UndoableCommand;

public class CommandPatternExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Command Pattern Example");
        Light light = new Light();
        UndoableCommand turnOn = new TurnOnLightCommand(light);
        UndoableCommand turnOff = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOn);
        remote.pressButton();

        remote.setCommand(turnOff);
        remote.pressButton();

        remote.pressUndo();
        remote.removeLastCommand();
        remote.pressUndo();
        System.out.println("Command Pattern Example end");
        System.out.println("--------------------------------------------------");
    }
}

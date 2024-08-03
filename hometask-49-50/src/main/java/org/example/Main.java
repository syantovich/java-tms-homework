package org.example;

import org.example.abstractFactory.AbstractFactoryExample;
import org.example.command.CommandPatternExample;
import org.example.observable.ObservableExample;
import org.example.templateMethod.TemplateMethodExample;

import java.util.List;

public class Main {
    public static final List<Runnable> tasks = List.of(
            new AbstractFactoryExample(),
            new ObservableExample(),
            new CommandPatternExample(),
            new TemplateMethodExample()
    );

    public static void main(String[] args) {
        for (Runnable task : tasks) {
            task.run();
        }
    }
}
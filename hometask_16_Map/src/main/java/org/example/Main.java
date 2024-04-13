package org.example;

import src.main.java.org.example.Tasks;

public class Main {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();

        System.out.println("Task 1");
        System.out.println(tasks.wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(tasks.wordMultiple(new String[]{"c", "b", "a"}));
        System.out.println(tasks.wordMultiple(new String[]{"c", "c", "c", "c"}));

        System.out.println("Task 2");
        System.out.println(tasks.pairs(new String[]{"code", "bug"}));
        System.out.println(tasks.pairs(new String[]{"man", "moon", "main"}));
        System.out.println(tasks.pairs(new String[]{"man", "moon", "good", "night"}));

    }
}

package org.syantovich;

import org.syantovich.abstr.Computer;
import org.syantovich.animals.Cat;
import org.syantovich.animals.Dog;
import org.syantovich.computers.Apple.IMac;
import org.syantovich.computers.Apple.Macbook;
import org.syantovich.computers.HP;
import org.syantovich.impl.Voice;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");

        Voice[] animals = {new Cat("Simba"), new Dog("Archi")};

        for (Voice animal : animals) {
            animal.doVoice();
            System.out.println();
        }

        System.out.println("Task 2");

        Computer[] computers = {new Macbook(), new IMac(), new HP()};

        for (Computer computer : computers) {
            computer.getClassName();
            System.out.println();
        }

    }
}

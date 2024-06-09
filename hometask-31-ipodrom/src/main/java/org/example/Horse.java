package org.example;

import com.github.javafaker.Faker;
import org.example.interfaces.Power;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

public class Horse implements Power {
    public String name;
    private int speed;
    private int age;

    @PostConstruct
    public void postInit(){
        Faker faker = new Faker();
        name = faker.name().firstName();

        age = ThreadLocalRandom.current().nextInt(14,36);
        speed = ThreadLocalRandom.current().nextInt(1,100);
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public double getPower() {
        return (double) (speed * age) / 10 ;
    }

    @Override
    public String toString() {
        return "Horse: " + name + " " + speed + " " + age;
    }
}

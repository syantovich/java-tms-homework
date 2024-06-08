package org.example;

import com.github.javafaker.Faker;
import org.example.interfaces.Power;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

@Scope("prototype")
public class Rider implements Power {
    private String name;
    private int age;
    private int experience;

    @PostConstruct
    public void postInit() {
        Faker faker = new Faker();
        name = faker.name().firstName();

        age = ThreadLocalRandom.current().nextInt(14, 36);
        experience = ThreadLocalRandom.current().nextInt(1, 16);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public double getPower() {
        return experience * ((double) age / 18 - 1);
    }

    @Override
    public String toString() {
        return "Rider: " + name + " " + age + " " + experience;
    }
}

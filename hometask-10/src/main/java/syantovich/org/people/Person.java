package syantovich.org.people;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import syantovich.org.animals.Cat;

@Getter
@Setter
@AllArgsConstructor
public class Person implements Cloneable {
    private String name;
    private int age;
    private double salary;

    private Cat cat;

    public Person(String name, int age, double salary) {
        this(name, age, salary, null);
    }

    @Override
    public String toString() {
        return "My name is " + name + ". I'm " + age + " years old. And my salary is " + salary + "." + (cat != null ? " I have a cat. " + cat : "");
    }

    @Override
    public int hashCode() {
        int nameLengthCode = name.length() > 8 ? 1 : 2;

        int salaryCode = Math.round(salary) > 1000 ? 36 : 24;

        return age * nameLengthCode + salaryCode;
    }

    @Override
    public Person clone() {
        try {
            Person newPerson = (Person) super.clone();
            if (newPerson.cat != null) {
                Cat newCat = this.getCat().clone();
                newPerson.setCat(newCat);
            }
            return newPerson;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

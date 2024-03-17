package syantovich.org;

import syantovich.org.animals.Cat;
import syantovich.org.enums.CatTypes;
import syantovich.org.people.Person;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("Alexey", 24, 8250, new Cat("Simba", CatTypes.BRITISH));
        Person person1 = person.clone();
        person1.setName("Ivan");
        person1.getCat().setName("Eva");
        System.out.println(person);
        System.out.println(person1);
    }
}

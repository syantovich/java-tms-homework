package syantovich.org;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String string = "Lorem, Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        System.out.println(string.length());

        System.out.println(string.split("\\.|\\,").length);

        System.out.println(string.substring(10));

        System.out.println(new StringBuilder(string).reverse());

        public class User {
            String name;
            int age;
            double salary;

            User(String name, int age, double salary) {
                this.name = name;
                this.age = age;
                this.salary = salary;
            }

            @Override
            public String toString() {
                String userInfoFormat = "My name is %s . I'm %d years old. And my current salary is %d";
                return String.format(userInfoFormat, this.name, this.age, this.salary);
            }
        }

        System.out.println(new User('Andrei', 48, 90000));
    }
}

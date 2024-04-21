package org.example;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");
        Function<String, String> changeBYNToUSDFunc = (string) -> {
            double amountBYN = Double.parseDouble(string.split(" ")[0]);
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            return formatter.format(amountBYN / 3.25);
        };
        System.out.println(changeBYNToUSDFunc.apply("2000 BYN"));


        System.out.println("Task 2");
        Consumer<String> changeBYNToUSDCons = (string) -> {
            double amountBYN = Double.parseDouble(string.split(" ")[0]);
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println(formatter.format(amountBYN / 3.25));
        };
        changeBYNToUSDCons.accept("2000 BYN");


        System.out.println("Task 3");
        Supplier<String> reverseString = () -> new StringBuilder(new Scanner(System.in).next()).reverse().toString();
        System.out.println(reverseString.get());
    }
}
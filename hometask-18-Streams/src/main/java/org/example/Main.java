package org.example;

import org.example.enums.ProductCategory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void runTask1() {

        List<Product> products = List.of(
                new Product("Samsung A2 50", 2000, ProductCategory.TV, true, List.of(
                        new Shop("shop 1", "Minsk", "some address 1", "375171111111"),
                        new Shop("shop 2", "Gomel", "some address 2", "375172222222"),
                        new Shop("shop 3", "Mogilev", "some address 3", "375173333333")
                ), new Manufacturer("Samsung", "China")),
                new Product("Samsung S23+", 2899, ProductCategory.MOBILE_PHONE, true, List.of(
                        new Shop("shop 4", "Minsk", "some address 4", "37517444444"),
                        new Shop("shop 2", "Grodno", "some address 2", "375172222222"),
                        new Shop("shop 6", "Mogilev", "some address 6", "3751766666666")
                ), new Manufacturer("Samsung", "Vietnam")),
                new Product("Iphone 15 pro max 1TB", 4000, ProductCategory.MOBILE_PHONE, false, List.of(
                        new Shop("shop 4", "Minsk", "some address 4", "375174444444"),
                        new Shop("shop 5", "Mogilev", "some address 5", "3751755555555")
                ), new Manufacturer("Apple", "USA")),
                new Product("Some chair", 200, ProductCategory.CHAIR, true, List.of(
                        new Shop("shop 7", "Minsk", "some address 1", "3751777777"),
                        new Shop("shop 2", "Gomel", "some address 2", "375172222222")
                ), new Manufacturer("ChairCompany", "China")),
                new Product("Sofa", 5000, ProductCategory.SOFA, true, List.of(
                        new Shop("shop 7", "Minsk", "some address 1", "3751777777"),
                        new Shop("shop 2", "Gomel", "some address 2", "375172222222")
                ), new Manufacturer("ChairCompany", "China"))
        );


//        1) определить самый дорогой и дешевый товар и 12) вывести товары отсортированные по стоимости (от большего к меньшему)

        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .toList();
        Product chip = sortedProducts.get(0);
        Product expensive = sortedProducts.get(sortedProducts.size() - 1);
        System.out.println("chip: " + chip + ", expensive: " + expensive);

        System.out.println("sorted products: " + sortedProducts);
//        2) найти все товары которые возможно доставить до покупателя
        List<Product> deliverableProducts = products.stream().
                filter(Product::isDeliverable)
                .toList();
        System.out.println("deliverableProducts: " + deliverableProducts);

//        3) посчитать среднюю стоимость товара указанной категории
        final ProductCategory selectedCategory = ProductCategory.MOBILE_PHONE;

        double averagePrice = products.stream()
                .filter(product -> product.getCategory() == selectedCategory)
                .mapToInt(Product::getPrice)
                .average()
                .getAsDouble();
        System.out.println("averagePrice " + averagePrice);

//        4) найти все товары определенного производителя
        String searchesManufacturer = "Samsung";
        List<Product> productsWithOneManufacturer = products.stream()
                .filter((product) -> product.getManufacturer().getName().equals(searchesManufacturer))
                .toList();
        System.out.println("productsWithOneManufacturer: " + productsWithOneManufacturer);

//        5) найти всех названия производителей указанной страны
        String searchedManufacturerCountry = "China";
        List<String> manufacturerNamesWithCountry = products.stream()
                .map(Product::getManufacturer)
                .filter((manufacturer -> Objects.equals(manufacturer.getCountry(), searchedManufacturerCountry)))
                .map(Manufacturer::getName)
                .distinct()
                .toList();
        System.out.println("manufacturerNamesWithCountry: " + manufacturerNamesWithCountry);

//        6) найти все магазины конкретного города
        String searchedCity = "Minsk";
        Collection<Shop> shopsWithSelectedCity = products.stream()
                .flatMap((product) -> product.getShops().stream())
                .filter(shop -> shop.getCity().equals(searchedCity))
                .collect(Collectors.toMap(Shop::getName, (shop) -> shop, (prev, next) -> next, HashMap::new))
                .values();
        System.out.println("shopsWithSelectedCity: " + shopsWithSelectedCity);

//        7) найти адрес магазина по указанному номеру телефона
        String searchedPhoneNumber = "375174444444";
        String address = products.stream()
                .flatMap(product -> product.getShops().stream())
                .filter(shop -> shop.getPhoneNumber().equals(searchedPhoneNumber))
                .limit(1)
                .map(Shop::getAddress)
                .findFirst().orElse("No shop");
        System.out.println("address: " + address);
//        8) все товары указанного номера магазина
        List<Product> productsByShopNumber = products.stream()
                .filter((product) -> product.getShops().stream()
                        .anyMatch(shop -> shop.getPhoneNumber().equals(searchedPhoneNumber)))
                .toList();
        System.out.println("productsByShopNumber: " + productsByShopNumber);

//        9) составить map где ключ это номер магазина, а значение - это номер телефона данного магазина
        Map<String, String> shopPhonesBYNames = products.stream()
                .flatMap(product -> product.getShops().stream())
                .collect(Collectors.toMap(Shop::getName, Shop::getPhoneNumber, (prev, next) -> next, HashMap::new));
        System.out.println("shopPhonesBYNames: " + shopPhonesBYNames);
//        10) узнать все ли товары указанной категории можно доставить до покупателя
        boolean isAllProductInCategoryAreDeliverable = products.stream()
                .filter(product -> product.getCategory() == selectedCategory)
                .allMatch(Product::isDeliverable);
        System.out.println("isAllProductInCategoryAreDeliverable: " + isAllProductInCategoryAreDeliverable);
//        11) посчитать количество магазинов
        int countOfShops = products.stream()
                .flatMap(product -> product.getShops().stream())
                .collect(Collectors.toMap(Shop::getName, Shop::getPhoneNumber, (prev, next) -> next, HashMap::new))
                .size();
        System.out.println("countOfShops: " + countOfShops);
    }

    public static void runTask2() {
//        1) Найти среднее значение первых 10 чисел.

        double averageFirstTen = Stream.iterate(1, (value) -> value + 1)
                .limit(10)
                .mapToInt(val -> val)
                .average()
                .getAsDouble();
        System.out.println("averageFirstTen: " + averageFirstTen);
//        2) Пропустить 5 чисел и вывести следующие 10 чисел, которые делятся на 3 без остатка
        System.out.println(
                Stream.iterate(1, (value) -> value + 1)
                        .skip(3)
                        .limit(10)
                        .filter((num) -> num % 3 == 0)
                        .toList()
        );
//        3) Посчитать сумму 20 подряд идущих чисел
        System.out.println(
                Stream.iterate(1, (value) -> value + 1)
                        .limit(20)
                        .mapToInt(val->val)
                        .sum()
        );
    }

    public static void main(String[] args) {
        runTask1();
        runTask2();
    }
}
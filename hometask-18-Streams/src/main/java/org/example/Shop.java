package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data @AllArgsConstructor
public class Shop {
    private String name;
    private String city;
    private String address;
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) && Objects.equals(city, shop.city) && Objects.equals(address, shop.address) && Objects.equals(phoneNumber, shop.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, address, phoneNumber);
    }
}

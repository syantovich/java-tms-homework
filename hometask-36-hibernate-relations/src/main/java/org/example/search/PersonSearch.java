package org.example.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class PersonSearch {
    private String firstName;
    private String lastName;
    private int minAge = 0;
    private int maxAge = 100;
}

package org.example.syantovich.services;

public class StringUtilsService {

    public int indexOfIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.toLowerCase().indexOf(searchStr.toLowerCase());
    }

    public boolean containsIgnoreCase(String str, String searchStr) {
        return indexOfIgnoreCase(str, searchStr) != -1;
    }
}

package src.main.java.org.example;

import java.util.HashMap;
import java.util.Map;

public class Tasks {
    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> mapResult = new HashMap<>();
        for (String word : strings) {
            if (mapResult.containsKey(word) && mapResult.get(word) == false) {
                mapResult.put(word, true);
            } else {
                mapResult.put(word, false);
            }
        }

        return mapResult;
    }

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> mapResult = new HashMap<>();
        for (String word : strings) {
            String first = word.substring(0, 1);
            String last = word.substring(word.length() - 1);
            mapResult.put(first, last);
        }
        return mapResult;
    }
}

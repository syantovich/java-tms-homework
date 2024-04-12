package org.synatovich;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashSet<User> hashUsers = new HashSet<>(getUsers());
        ArrayList<User> usersWithMoreTwoActions = new ArrayList<>();
        for (User hashUser : hashUsers) {
            if (hashUser != null) {
                if (hashUser.getTaskList().size() > 2) {
                    usersWithMoreTwoActions.add(hashUser);
                } else if (!usersWithMoreTwoActions.isEmpty()) {
                    break;
                }
            }
        }

        System.out.println("Users with more two actions: " + usersWithMoreTwoActions);

        TreeSet<User> usersTreeSetWithName = new TreeSet<>(getUsers());
        List<String> uniqNames = new ArrayList<>();
        for (User userTreeSet : usersTreeSetWithName) {
            uniqNames.add(userTreeSet.getName());
        }
        System.out.println("Users by uniq name: " + uniqNames);

        TreeSet<User> usersTreeSetWithAge = new TreeSet<>(new UserWorkExperienceComparator());
        usersTreeSetWithAge.addAll(getUsers());
        System.out.println("Users by age: " + usersTreeSetWithAge);
    }

    private static Collection<User> getUsers() {
        User user1 = new User("Alex", 1, List.of(new String[]{"action1", "action2"}));
        User user2 = new User("Andrey", 2, List.of(new String[]{"action3", "action4", "action5"}));
        User user3 = new User("John", 3, List.of(new String[]{"action1", "action2"}));
        User user4 = new User("Jane", 4, List.of(new String[]{"action1", "action2"}));
        User user5 = new User("June", 5, List.of(new String[]{"action1", "action2", "action4", "action5"}));
        User user6 = new User("June", 6, List.of(new String[]{"action11", "action22", "action43", "action54"}));

        return List.of(user4, user2, user3, user1, user5, user6);
    }
}

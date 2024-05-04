package org.synatovich;

import java.util.Comparator;

public class UserWorkExperienceComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getWorkExperience() - o1.getWorkExperience();
    }
}

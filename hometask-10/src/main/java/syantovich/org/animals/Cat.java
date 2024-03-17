package syantovich.org.animals;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import syantovich.org.enums.CatTypes;

@AllArgsConstructor
@Getter
@Setter
public class Cat implements Cloneable {
    private String name;
    @Setter(AccessLevel.PRIVATE)
    private CatTypes type;

    @Override
    public String toString() {
        return "I'm cat " + name + ". And my type is " + type;
    }

    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

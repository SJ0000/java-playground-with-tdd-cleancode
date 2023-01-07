package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("Car name length must less than 6");
        }
    }

    public String getName() {
        return name;
    }
}

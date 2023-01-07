package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class NameTest {

    @Test
    @DisplayName("Name은 최대 5글자 이다.")
    void validate(){
        assertThatThrownBy(()-> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
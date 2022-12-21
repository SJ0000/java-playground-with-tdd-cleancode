package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual1 = "1,2".split(",");
        assertThat(actual1).containsExactly("1","2");

        String[] actual2 = "1".split(",");
        assertThat(actual2).contains("1");
    }

    @Test
    void substring(){
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메서드에 벗어난 인덱스가 들어오게 되면 StringIndexOutOfBoundException을 발생시킨다.")
    void charAt(){
        char b = "abc".charAt(1);
        assertThat(b).isEqualTo('b');

        assertThatThrownBy(()->"abc".charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

package racingcar.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    /**
     * 기능 요구사항
     *
     * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우
     * 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
     *
     * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
     * 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
     * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
     *
     * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     */

    @Test
    @DisplayName("빈 문자열을 입력한 경우 0이 반환된다.")
    void emptyTest(){
        int result = StringCalculator.addAll("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표를 구분자로 가지는 문자열의 숫자를 더한다")
    void defaultDelimiterTest1(){
        String input = "1,2,3,4";
        int result = StringCalculator.addAll(input);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("콜론을 구분자로 가지는 문자열의 숫자를 더한다")
    void defaultDelimiterTest2(){
        String input = "1:2:3:4";
        int result = StringCalculator.addAll(input);
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,-3","1,aa,5534"})
    @DisplayName("숫자가 아니거나 음수를 전달한 경우 예외 반환")
    void invalidInputTest(String input){
        assertThatThrownBy(()-> StringCalculator.addAll(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void custom(){
        String input = "//;\n1;2;3";
        int result = StringCalculator.addAll(input);
        assertThat(result).isEqualTo(6);
    }
}

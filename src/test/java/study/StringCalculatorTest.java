package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class StringCalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void calculatorTest(){
        InputStream is = new ByteArrayInputStream("2 + 3 * 4 / 2".getBytes());
        System.setIn(is);
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        calculator.run();
        Assertions.assertThat(os.toString()).isEqualTo("10");
    }

    static class Calculator{

        void run(){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] values = input.split(" ");

            int current = Integer.parseInt(values[0]);
            for(int i=2;i< values.length;i+=2){
                String operator = values[i-1];
                int operand = Integer.parseInt(values[i]);
                current = calculate(current,operator,operand);
            }
            System.out.print(current);
        }

        int calculate(int op1, String operator, int op2){
            if(operator.equals("+"))
                return op1+op2;

            if(operator.equals("-"))
                return op1-op2;

            if(operator.equals("*"))
                return op1*op2;

            if(operator.equals("/"))
                return op1/op2;

            throw new RuntimeException("허용되지 않는 연산자입니다.");
        }
    }
}
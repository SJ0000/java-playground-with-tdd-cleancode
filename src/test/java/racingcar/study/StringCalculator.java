package racingcar.study;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int addAll(String input) {
        if(input.length() == 0)
            return 0;

        List<String> delimiters = new ArrayList<>(List.of(":",","));
        if(input.startsWith("//")){
            String customDelimiter = parseCustomDelimiter(input);
            delimiters.add(customDelimiter);
            int startIndex = input.indexOf("\n");
            input = input.substring(startIndex+1);
        }

        String regex = toRegix(delimiters);
        String[] nums = input.split(regex);
        System.out.println(Arrays.toString(nums));
        for (String num : nums) {
            validate(num);
        }

        return Arrays.stream(nums)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElseGet(()-> 0);
    }

    private static void validate(String str){
        if(!str.matches("[0-9]")){
            throw new RuntimeException("invalid input");
        }
    }

    private static String parseCustomDelimiter(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            return m.group(1);
        }
        return "";
    }

    private static String toRegix(List<String> delimiters){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String delimiter : delimiters) {
            sb.append(delimiter);
        }
        sb.append("]");
        return sb.toString();
    }
}

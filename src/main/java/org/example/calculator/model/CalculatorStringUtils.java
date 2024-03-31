package org.example.calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringUtils {

    private static final int FIRST_GROUP_OF_REGEX = 1;
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";
    private static final String CUSTOM_OPERANDS_REGEX = "//.\n(.+)";

    private CalculatorStringUtils() {

    }

    public static String extractDelimiterWithRegex(String string) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(string);
        if (matcher.find()) {
            return matcher.group(FIRST_GROUP_OF_REGEX);
        }
        return DEFAULT_DELIMITER;
    }

    public static String extractOperandStringWithRegex(String string) {
        Matcher m = Pattern.compile(CUSTOM_OPERANDS_REGEX).matcher(string);
        if (m.find()) {
            return m.group(FIRST_GROUP_OF_REGEX);
        }
        return string;
    }
}

package com.company.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String EMPTY = "";

    static public Map<String, List<String>> convert(List<String> strings) {
        Function<String, List<String>> valueMapper = x -> Arrays.stream(getSubordinate(x).split(COMMA)).map(String::trim).collect(Collectors.toList());
        return strings.stream().collect(Collectors.toMap(x -> x.split(COLON)[0].trim(), valueMapper));
    }

    private static String getSubordinate(String x) {
        return x.split(COLON).length > 1 ? x.split(COLON)[1] : EMPTY;
    }
}

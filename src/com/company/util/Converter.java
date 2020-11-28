package com.company.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter {
    static public Map<String, List<String>> convert(List<String> strings) {
        Function<String, List<String>> valueMapper = x -> Arrays.stream(getSubordinate(x).split(",")).map(y -> y.trim()).collect(Collectors.toList());
        return strings.stream().collect(Collectors.toMap(x -> x.split(":")[0].trim(), valueMapper));
    }

    private static String getSubordinate(String x) {
        String result = x.split(":").length > 1 ? x.split(":")[1] : "";
        return result;
    }
}

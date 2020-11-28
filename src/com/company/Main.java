package com.company;

import com.company.service.SubordinateHierarchyCreateService;
import com.company.service.SubordinateHierarchyCreateServiceImpl;
import com.company.util.Converter;

import java.util.List;

public class Main {
    private static List<String> pollResults = List.of(
            "служанка Аня",
            "управляющий Семен Семеныч: крестьянин Федя, доярка Нюра",
            "дворянин Кузькин: управляющий Семен Семеныч, жена Кузькина, экономка Лидия Федоровна",
            "экономка Лидия Федоровна: дворник Гена, служанка Аня",
            "доярка Нюра",
            "кот Василий: человеческая особь Катя",
            "дворник Гена: посыльный Тошка",
            "киллер Гена",
            "зажиточный холоп: крестьянка Таня",
            "секретарь короля: зажиточный холоп, шпион Т",
            "шпион Т: кучер Д",
            "посыльный Тошка: кот Василий",
            "аристократ Клаус",
            "просветленный Антон"
    );

    public static void main(String[] args) {
       // System.out.println(Converter.convert(pollResults));
        SubordinateHierarchyCreateService subordinateHierarchyCreateService=new SubordinateHierarchyCreateServiceImpl();
        subordinateHierarchyCreateService.createSubordinateHierarchy(Converter.convert(pollResults));
    }
}

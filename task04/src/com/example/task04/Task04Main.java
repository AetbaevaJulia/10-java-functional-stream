package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        buffer.lines()
                .flatMap(x -> Stream.of(x.split("\\P{L}")) // разделяем по всем символам, которые не буквы
                .filter(t -> !t.isEmpty())
                .map(String::toLowerCase))

                .collect(Collectors.groupingBy(t -> t, Collectors.counting()))
                .entrySet()
                .stream()

                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))

                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(t -> System.out.print(t + '\n'));
    }

}

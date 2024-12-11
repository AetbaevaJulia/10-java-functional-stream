package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {
        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        Iterator<? extends T> iterator = stream.iterator(); // итератор для обхода стрима
        // Берем первый элемент из итератора, если он есть. Иначе - null
        T element = iterator.hasNext() ? iterator.next() : null;
        T max = element;
        T min = element;
        while(iterator.hasNext()) {
            element = iterator.next();
            min = order.compare(element, min) < 0 ? element : min;
            max = order.compare(element, max) > 0 ? element : max;
        }
        minMaxConsumer.accept(min, max);
    }
}

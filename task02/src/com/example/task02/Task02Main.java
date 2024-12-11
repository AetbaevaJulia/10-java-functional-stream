package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static int GetGrayCode(int g){
        return g ^ (g >> 1); // формула с википедии
    }

    public static IntStream cycleGrayCode(int n) {
        if (n >= 1 && n <= 16){ // Битность кодов задается аргументом n в пределах от 1 до 16.
            return IntStream.iterate(0, g -> g + 1).map(g -> GetGrayCode(g % (int)Math.pow(2, n)));
        }
        throw new IllegalArgumentException(); // ошибка, если n не лежит в [1, 16]
    }
}

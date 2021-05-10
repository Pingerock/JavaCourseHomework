package main.java;

import java.util.stream.Stream;

public class StreamAPIExerciseTwoB {

    public static void main(String[] args) {
        Stream<String> symbols = Stream.of("aa", "bbb", "ccc", "dd", "eee", "ff", "gg");
        symbols.forEach(s -> {
            if (s.length() < 3) {
                s = s.concat("x");
            }
            System.out.println(s);
        });
    }
}

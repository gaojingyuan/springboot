package com.gao.practice.lambda;

import java.util.Optional;

/**
 * Created by jionglu on 17/4/19.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> s = Optional.of("input");
        System.out.println(s.map(OptionalTest::getOutput));
        System.out.println(s.flatMap(OptionalTest::getOutputOpt));
    }

    static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }

    static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }
}

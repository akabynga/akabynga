package com.akabynga;

public class Test {

    public static void main(String[] args) {
        String test = "TesT string123 3 !, 1qweqwe";
        StringBuilder sb = new StringBuilder(test);

        System.out.println(sb.reverse());

        System.out.println(test.replaceAll("[^A-Za-z0-9]", ""));
    }
}

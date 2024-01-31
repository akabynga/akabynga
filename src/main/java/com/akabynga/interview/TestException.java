package com.akabynga.interview;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public class TestException {
    public TestException() {
        try {
            System.out.println(absorbingEx());
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String absorbingEx() throws IOException,
            EOFException {
        try {
            throw new EOFException("EOFException");
//      } catch (EOFException e) {
//          System.out.println("catch " + e.getMessage());
        } finally {
            throw new IOException("finally IOException");
        }
    }

    public static void main(String[] args) {
        new TestException();
        System.exit(0);
    }
}
package com.akabynga.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCompressionTest {


    @Test
    public void giverArrayOfCharacters_compress_expectArrayEquals() {

        // arrange
        StringCompression solution = new StringCompression();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] expected = {'a', '2', 'b', '2', 'c', '3', 'c'};

        // act
        solution.compress(chars);

        //assert
        Assertions.assertArrayEquals(expected, chars);
    }
}

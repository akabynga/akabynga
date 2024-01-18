package com.akabynga.binary.day1;

public class Gerlanda {
    public static void main(String[] args) throws InterruptedException {

        int v = 0b00000000_11111111_00000000_11111111;
        while (true) {
            for (int i = 31; i >= 0; i--) {
                int bit = (v >> i) & 1;
                System.out.print(bit == 1 ? 'O' : '-');
            }
            v = blink(v);
            Thread.sleep(1000);
            System.out.println();
        }
    }

    public static int blink(int v) {
        return ~v;
    }

    public static int run(int v) {
        return v << 1;
    }
}

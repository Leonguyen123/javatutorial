package com.example.javatutorial.javacore;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args){

        // Java doesn't support operator overloading for BigInteger.

        BigInteger a = new BigInteger("100000000000000000000");
        BigInteger b = new BigInteger("200000000000000000000");

        // BigInteger c = a + b; // ❌ Compile error

        Integer d = 1000;
        Integer e = 1000;

        Integer f = d + e;
    }
}

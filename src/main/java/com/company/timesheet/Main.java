package com.company.timesheet;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        BigInteger p = primeGenerator.generatePrime(2048);
        BigInteger q = primeGenerator.generatePrime(2048);
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(BigInteger.probablePrime(5, rnd));
        }
        System.out.println("p = " + p);
        System.out.println("q = " + q);

        System.out.println("p (hex) = " + p.toString(16));
        System.out.println("q (hex) = " + q.toString(16));

        System.out.println("p bit length = " + p.bitLength());
        System.out.println("q bit length = " + q.bitLength());

        System.out.println("p is prime? " + p.isProbablePrime(100));
        System.out.println("q is prime? " + q.isProbablePrime(100));
    }
}
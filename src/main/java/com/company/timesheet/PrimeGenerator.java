package com.company.timesheet;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;

public class PrimeGenerator {
    private final SecureRandom random;

    public PrimeGenerator() {
        this.random = new SecureRandom();
    }

    public PrimeGenerator(SecureRandom random) {
        this.random = Objects.requireNonNull(random, "Random must not be null");
    }

    public BigInteger generatePrime(int bitLength) {
        return BigInteger.probablePrime(bitLength, random);
    }
}

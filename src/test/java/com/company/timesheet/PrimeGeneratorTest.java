package com.company.timesheet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class PrimeGeneratorTest {

    @Test
    void generatePrime_ProbablePrimeTest() {
        SecureRandom random = Mockito.mock(SecureRandom.class);
        PrimeGenerator sut = new PrimeGenerator(random);

        BigInteger fakePrime = BigInteger.valueOf(23);

        try (MockedStatic<BigInteger> mockBI = Mockito.mockStatic(BigInteger.class)) {
            mockBI.when(() -> BigInteger.probablePrime(5, random))
                    .thenReturn(fakePrime);

            BigInteger result = sut.generatePrime(5);
            assertEquals(fakePrime, result);
            mockBI.verify(() -> BigInteger.probablePrime(5, random), times(1));
        }
    }

    @Test
    void generatePrime_BitLengthTest() {
        PrimeGenerator sut = new PrimeGenerator();

        BigInteger prime = sut.generatePrime(16);
        assertEquals(16, prime.bitLength());
    }
}

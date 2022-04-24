package com.gmail.evanloafakahaitao.prac.class6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class BigIntTest {

    @Test
    @DisplayName("My first stupid BigInteger test lmao")
    void bigIntCalc() {
        assertAll("test heading lol",
                () -> assertEquals(5, BigInt.bigIntCalc(BigInteger.valueOf(2), BigInteger.valueOf(2)).intValue()),
                () -> assertEquals(10, BigInt.bigIntCalc(BigInteger.valueOf(5), BigInteger.valueOf(1)).intValue()),
                () -> assertEquals(65, BigInt.bigIntCalc(BigInteger.valueOf(8), BigInteger.valueOf(8)).intValue()),
                () -> assertEquals(15, BigInt.bigIntCalc(BigInteger.valueOf(6), BigInteger.valueOf(2)).intValue()));
    }
}
package com.gmail.evanloafakahaitao.prac.class6;

import java.math.BigInteger;

public class BigInt {

    public static void main(String[] args) {
        BigInteger result = BigInteger.valueOf(2*2+4/2);
        System.out.println(String.format("BigInteger calc result is: %s", result));
    }

    public static BigInteger bigIntCalc(BigInteger a, BigInteger b) {
        return a.multiply(b).add(a.divide(b));
    }
}

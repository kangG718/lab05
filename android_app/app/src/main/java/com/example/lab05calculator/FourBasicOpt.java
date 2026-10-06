package com.example.lab05calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public final class FourBasicOpt {
    private FourBasicOpt() {}

    public static BigDecimal calculate(BigDecimal x, BigDecimal y, int operation) {
        switch (operation) {
            case 0:
                return x.add(y);
            case 1:
                return x.subtract(y);
            case 2:
                if (y.signum() == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return x.divide(y, MathContext.DECIMAL64);
            case 3:
                return x.multiply(y);
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }
}

package com.company.spider.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static int BASE = 5;
    private Calculator calculator;

    @Before
    public void initialize() {
        calculator = new Calculator(BASE);
    }

    @Test
    public void addBase() {
        int x = 3;
        int result = calculator.addBase(x);

        // 检查result是否正确，是否等于8
        assertEquals(3, result);
        assertTrue(3 == result);
    }

    @Test
    public void shouldAddXAndY() {
        int x = 1;
        int y = 5;
        int result = calculator.add(x, y);

        assertEquals(6, result);
    }
}

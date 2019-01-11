/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ofs.training;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author vinothkumarc
 * @since  Aug 27, 2018
 */
@Test
public class MathTest {
    private Math math;

    @BeforeClass
    private void init() {
        this.math = new Math();
    }

    @Test
    private void testDivide_positive() {
        testDivide_positive(50, 2, 25);
        testDivide_positive(100, 25, 4);
        testDivide_positive(75, 3, 25);
    }

    private static final String INPUTS_MSG = "INPUTS: Dividend = %s, Divisor = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    private void testDivide_positive(int dividend, int divisor, int expectedResult) {
        try {
            int actualResult = this.math.divide(dividend, divisor);
            Assert.assertEquals(actualResult, expectedResult, String.format(INPUTS_MSG, dividend, divisor));
        } catch (Exception e) {
            Assert.fail(String.format(INPUTS_MSG, dividend, divisor) +
                        String.format(ASSERT_FAIL_MSG, expectedResult, e.getMessage()),
                        e);
        }
    }

    @Test
    private void testDivide_negative() {
        testDivide_negative(50, 0, Math.ERR_DIVIDE_BY_ZERO);
        testDivide_negative(25, 0, Math.ERR_DIVIDE_BY_ZERO);
    }

    private void testDivide_negative(int dividend, int divisor, String expectedErrCode) {
        try {
            int actualResult = this.math.divide(dividend, divisor);
            Assert.fail(String.format(INPUTS_MSG, dividend, divisor) +
                        String.format(ASSERT_FAIL_MSG, expectedErrCode, actualResult));
        } catch (Exception e) {
            String actualErrCode = e.getMessage();
            Assert.assertEquals(actualErrCode, expectedErrCode, String.format(INPUTS_MSG, dividend, divisor));
        }
    }
    
    @DataProvider
    Object[][] dpDivide_positive() {
        return new Object[] {50, 2, 25}, new Object[]{20, 2, 10};
    }
}

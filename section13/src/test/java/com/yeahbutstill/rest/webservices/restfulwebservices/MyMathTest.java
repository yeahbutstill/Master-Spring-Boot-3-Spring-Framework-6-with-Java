package com.yeahbutstill.rest.webservices.restfulwebservices;

import com.yeahbutstill.rest.webservices.restfulwebservices.unit.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyMathTest {

    private final MyMath myMath = new MyMath();

    @Test
    void calculatedSumThreeMemberArray() {
        Assertions.assertEquals(6, myMath.calculateSum(new Integer[]{1,2,3}));
    }

    @Test
    void basic() {
        // Absence of failure is success
        // Test condition or Assert
        Integer[] numbers = {};
        Integer actualResult = myMath.calculateSum(numbers);
        Integer expectedResult = 0;

        Assertions.assertEquals(expectedResult, actualResult);
    }

}

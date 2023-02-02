package com.yeahbutstill.rest.webservices.restfulwebservices.unit;

public class MyMath {

    // {1,2,3} => 1+2+3 = 6
    public Integer calculateSum(Integer[] numbers) {
        Integer sum = 0;
        for (Integer number:numbers) {
            sum += number;
        }
        return sum;
    }

}

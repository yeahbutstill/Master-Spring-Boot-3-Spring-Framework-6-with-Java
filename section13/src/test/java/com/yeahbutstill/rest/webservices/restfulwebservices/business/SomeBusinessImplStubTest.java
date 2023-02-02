package com.yeahbutstill.rest.webservices.restfulwebservices.business;


import com.yeahbutstill.rest.webservices.restfulwebservices.business.dataservice.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

    @Test
    void findTheGreatTestFormAllDataScenario() {
        DataService dataServiceStub1 = new DataServiceStub1();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub1);
        Integer result = someBusiness.findTheGreatTestFormAllData();
        Assertions.assertEquals(100, result);
    }

    @Test
    void findTheGreatTestFormAllDataWithOneValue() {
        DataService dataServiceStub2 = new DataServiceStub2();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub2);
        Integer result = someBusiness.findTheGreatTestFormAllData();
        Assertions.assertEquals(50, result);
    }

}

class DataServiceStub1 implements DataService {

    @Override
    public Integer[] retrieveAllData() {
        return new Integer[] {100, 50, 30, 25, 5, 40, 10};
    }

}

class DataServiceStub2 implements DataService {

    @Override
    public Integer[] retrieveAllData() {
        return new Integer[] {50};
    }

}
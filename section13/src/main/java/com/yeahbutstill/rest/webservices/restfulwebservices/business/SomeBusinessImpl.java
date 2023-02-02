package com.yeahbutstill.rest.webservices.restfulwebservices.business;

import com.yeahbutstill.rest.webservices.restfulwebservices.business.dataservice.DataService;

public class SomeBusinessImpl {

    private final DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public Integer findTheGreatTestFormAllData() {
        Integer[] data = dataService.retrieveAllData();
        Integer greatTestValue = Integer.MIN_VALUE;
        for (Integer value:data) {
            if (value > greatTestValue) {
                greatTestValue = value;
            }
        }
        return greatTestValue;
    }

}

package com.yeahbutstill.outhwithspingsecurity.service;

import com.yeahbutstill.outhwithspingsecurity.repository.impl.DataService1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private final DataService1Impl dataService1Impl;

    @Autowired
    public BusinessService1(DataService1Impl dataService1Impl) {
        this.dataService1Impl = dataService1Impl;
    }

    public int calculateMax() {

        int[] data = dataService1Impl.retrieveData();
        //throw new RuntimeException("Something Went Wrong");

        return Arrays.stream(data).max().orElse(0);
    }

}

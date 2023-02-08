package com.yeahbutstill.oauthwithspingsecurity.service;

import com.yeahbutstill.oauthwithspingsecurity.repository.impl.DataRepositoryImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private final DataRepositoryImpl1 dataService1Impl1;

    @Autowired
    public BusinessService2(DataRepositoryImpl1 dataService1Impl1) {
        this.dataService1Impl1 = dataService1Impl1;
    }

    public int calculateMin() {

        int[] data = dataService1Impl1.retrieveData();
        //throw new RuntimeException("Something Went Wrong");

        return Arrays.stream(data).min().orElse(0);
    }

}

package com.yeahbutstill.oauthwithspingsecurity.service;

import com.yeahbutstill.oauthwithspingsecurity.annotation.TrackTime;
import com.yeahbutstill.oauthwithspingsecurity.repository.impl.DataRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private final DataRepositoryImpl dataService1Impl;

    @Autowired
    public BusinessService1(DataRepositoryImpl dataService1Impl) {
        this.dataService1Impl = dataService1Impl;
    }

    @TrackTime
    public int calculateMax() {

        int[] data = dataService1Impl.retrieveData();
        //throw new RuntimeException("Something Went Wrong");

        return Arrays.stream(data).max().orElse(0);
    }

}

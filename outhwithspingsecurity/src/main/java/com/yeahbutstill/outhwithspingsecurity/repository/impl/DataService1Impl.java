package com.yeahbutstill.outhwithspingsecurity.repository.impl;

import com.yeahbutstill.outhwithspingsecurity.repository.DataService1;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1Impl implements DataService1 {

    @Override
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55, 65};
    }

}

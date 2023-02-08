package com.yeahbutstill.oauthwithspingsecurity.repository.impl;

import com.yeahbutstill.oauthwithspingsecurity.annotation.TrackTime;
import com.yeahbutstill.oauthwithspingsecurity.repository.DataRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepositoryImpl implements DataRepository {

    @Override
    @TrackTime
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55, 65};
    }

}

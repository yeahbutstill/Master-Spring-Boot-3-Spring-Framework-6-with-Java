package com.yeahbutstill.oauthwithspingsecurity.repository.impl;

import com.yeahbutstill.oauthwithspingsecurity.annotation.TrackTime;
import com.yeahbutstill.oauthwithspingsecurity.repository.DataRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepositoryImpl1 implements DataRepository {

    @Override
    @TrackTime
    public int[] retrieveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new int[] {1111, 2222, 3333, 4444, 5555, 6565};
    }

}

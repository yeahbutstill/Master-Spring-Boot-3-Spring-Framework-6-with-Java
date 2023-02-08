package com.yeahbutstill.oauthwithspingsecurity.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository {

    int[] retrieveData();

}

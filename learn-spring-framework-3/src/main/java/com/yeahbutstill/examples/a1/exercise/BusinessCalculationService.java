package com.yeahbutstill.examples.a1.exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class BusinessCalculationService {

    private final DataService dataService;

    public BusinessCalculationService(@Qualifier("mysqlDbDataServiceQualifier") DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

}

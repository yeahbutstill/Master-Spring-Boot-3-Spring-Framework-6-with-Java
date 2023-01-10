package com.yeahbutstill.examples.cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;

//@Component
@Named
@Slf4j
public class BusinessService {

    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        log.info("Setter Injection");
        this.dataService = dataService;
    }
}

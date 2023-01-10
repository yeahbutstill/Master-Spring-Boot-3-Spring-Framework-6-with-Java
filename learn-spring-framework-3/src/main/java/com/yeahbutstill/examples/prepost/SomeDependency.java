package com.yeahbutstill.examples.prepost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SomeDependency {
    public void getReady() {
        log.info("Some logic using SomeDependency");
    }

    public void destroy() {
        log.info("Cleanup");
    }
}

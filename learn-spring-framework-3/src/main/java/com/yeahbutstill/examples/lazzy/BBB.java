package com.yeahbutstill.examples.lazzy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Slf4j
public class BBB {
    private final AAA aaa;

    public BBB(AAA aaa) {
        log.info("Create and call");
        this.aaa = aaa;
    }

    public void doSometing() {
        log.info("Do Something");
    }

}

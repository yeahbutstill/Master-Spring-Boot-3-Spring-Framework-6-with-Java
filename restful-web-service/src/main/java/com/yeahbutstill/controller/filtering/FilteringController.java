package com.yeahbutstill.controller.filtering;

import com.yeahbutstill.bean.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3", "value4", "value5");
    }

    @GetMapping(path = "/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4", "value5"),
                new SomeBean("value6", "value7", "value8", "value9", "value10"));
    }

}

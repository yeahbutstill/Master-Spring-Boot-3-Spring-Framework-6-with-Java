package com.yeahbutstill.examples.a1;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class YourBusiness {

    private final Dependecy1 dependecy1;
    private final Dependecy2 dependecy2;


//    DI with Constructors but this recommeded by spring team
    @Autowired
    public YourBusiness(Dependecy1 dependecy1, Dependecy2 dependecy2) {
        this.dependecy1 = dependecy1;
        this.dependecy2 = dependecy2;
    }


//    DI with Setter but this recommeded by spring team
//    @Autowired
//    public void setDependecy1(Dependecy1 dependecy1) {
//        this.dependecy1 = dependecy1;
//    }
//
//    @Autowired
//    public void setDependecy2(Dependecy2 dependecy2) {
//        this.dependecy2 = dependecy2;
//    }


}

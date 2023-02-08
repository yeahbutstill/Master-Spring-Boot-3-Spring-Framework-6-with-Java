package com.yeahbutstill.oauthwithspingsecurity.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.yeahbutstill.oauthwithspingsecurity.*.*.*(..))")
    public void businessDataPackageConfig() {}

    @Pointcut("execution(* com.yeahbutstill.oauthwithspingsecurity.service.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.yeahbutstill.oauthwithspingsecurity.repository.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(businessService1)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.yeahbutstill.oauthwithspingsecurity.annotation.TrackTime)")
    public void trackTimeAnnotation() {}

}

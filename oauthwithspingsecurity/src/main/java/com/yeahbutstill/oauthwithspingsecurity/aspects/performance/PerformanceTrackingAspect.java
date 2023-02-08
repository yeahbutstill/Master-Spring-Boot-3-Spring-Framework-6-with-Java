package com.yeahbutstill.oauthwithspingsecurity.aspects.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //@Around("com.yeahbutstill.oauthwithspingsecurity.aspects.CommonPointcutConfig.businessDataPackageConfig()")
    @Around("com.yeahbutstill.oauthwithspingsecurity.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start timer
        long startTimeMillis = System.currentTimeMillis();

        // Execute the method
        Object proceed = proceedingJoinPoint.proceed();

        // Stop timer
        long stopTimeMillis = System.currentTimeMillis();
        long executionDuration = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);

        return proceed;
    }

}

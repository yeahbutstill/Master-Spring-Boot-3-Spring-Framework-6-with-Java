package com.yeahbutstill.oauthwithspingsecurity.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    @Before("com.yeahbutstill.oauthwithspingsecurity.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMehodCallBeforeExecution(JoinPoint joinPoint) {
        // Logic - What?
        logger.info("Before aspect - {} method is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.yeahbutstill.oauthwithspingsecurity.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After aspect - {} has executed with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "com.yeahbutstill.oauthwithspingsecurity.aspects.CommonPointcutConfig.businessDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing aspect - {} has thrown an exception: {}", joinPoint, exception);
    }

    @AfterReturning(pointcut = "com.yeahbutstill.oauthwithspingsecurity.aspects.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning aspect - {} has return: {}", joinPoint, resultValue);
    }
}

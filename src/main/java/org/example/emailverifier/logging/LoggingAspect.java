package org.example.emailverifier.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(org.example.emailverifier.logging.Loggable)")
    public void loggableMethods(){
    }

    @Pointcut("@annotation(org.example.emailverifier.logging.Loggable)")
    public void exceptionMethod(){
    }

    @Before("loggableMethods()")
    public void logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Calling method: {} with args: {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
        joinPoint.proceed();
    }

    @AfterReturning(pointcut = "loggableMethods() || exceptionMethod()", returning = "result")
    public void logAfterReturning(ProceedingJoinPoint joinPoint, Object result) throws Throwable {
        logger.info("Method {} returned: {}", joinPoint.getSignature(), result);
        joinPoint.proceed();
    }

    @AfterThrowing(pointcut = "loggableMethods() || exceptionMethod()", throwing = "ex")
    public void logAfterThrowing(ProceedingJoinPoint joinPoint, Throwable ex) throws Throwable {
        logger.error("Method {} threw exception: {}", joinPoint.getSignature(), ex.getMessage());
        joinPoint.proceed();
    }
}

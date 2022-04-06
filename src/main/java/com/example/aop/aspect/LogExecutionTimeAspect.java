package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogExecutionTimeAspect {
    @Around("within(com.example.aop.service.impl.UselessService) || " +
            "@annotation(com.example.aop.annotation.LogExecutionTime)")
    public Object timer(ProceedingJoinPoint point) throws Throwable {

        String methodName = String.format("%s.%s",
                point.getStaticPart().getSignature().getDeclaringType().getName(),
                point.getSignature().getName());

        log.info("Before {} execution", methodName);

        long startAt = System.nanoTime();

        try {
            return point.proceed();
        } finally {
            long executedTime = (System.nanoTime() - startAt)/1000000;
            log.warn("{} execution took {}ms", methodName, executedTime);
        }
    }
}

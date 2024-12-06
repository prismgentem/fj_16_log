package org.example.fj_16_metrics_log.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
public class StructuralLogAspect {
    @Around("@annotation(org.example.fj_16_metrics_log.aop.StructuralLog)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        var requestId = UUID.randomUUID().toString();
        try (var ignored = MDC.putCloseable("RequestId", requestId)) {
            return pjp.proceed();
        }
    }
}

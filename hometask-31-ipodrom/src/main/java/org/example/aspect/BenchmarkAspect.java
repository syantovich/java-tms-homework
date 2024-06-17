package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class BenchmarkAspect {
    @Around("@annotation(org.example.annotation.Benchmark)")
    public Object aroundBenchmark(ProceedingJoinPoint joinPoint) {
        Object result = null;
        long start = System.nanoTime();
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long end = System.nanoTime();

        double elapsed = (end - start) / 1_000_000.00;
        String name = joinPoint.getSignature().getName();
        System.out.println("Method ( " + name + " ) took " + elapsed + " ms");
        return result;
    }
}

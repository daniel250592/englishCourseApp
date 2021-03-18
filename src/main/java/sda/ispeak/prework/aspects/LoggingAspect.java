//package sda.ispeak.prework.aspects;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class LoggingAspect {
//
//    @Around("execution(* sda.ispeak.prework..*.*(..))")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("{} starting", joinPoint.getSignature());
//        long start = System.currentTimeMillis();
//
//        Object result = joinPoint.proceed();
//
//        log.info("{} finished in {} ms", joinPoint.getSignature(), System.currentTimeMillis() - start);
//
//        return result;
//    }
//}

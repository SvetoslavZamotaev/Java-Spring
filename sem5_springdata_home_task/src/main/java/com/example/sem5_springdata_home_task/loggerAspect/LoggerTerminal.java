package com.example.sem5_springdata_home_task.loggerAspect;

import org.apache.el.stream.Stream;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
// Логгер-класс ДЛЯ ВЫВОДА ИНФОРМАЦИИ
@Aspect
@Component
public class LoggerTerminal {

    private Logger logger = Logger.getLogger(LoggerTerminal.class.getName());

    @Around("execution(* com.example.sem5_springdata_home_task.service.*.*(..))")
    public Object logInTerminal(ProceedingJoinPoint joinPoint) throws Throwable {
        List<Object> listArgs = Arrays.asList(joinPoint.getArgs());
        logger.info("all args : "+ listArgs);
        logger.info( joinPoint.getSignature().getName()+" Method will Execute!!!");
        Object returnedByMethod = joinPoint.proceed();
        logger.info( joinPoint.getSignature().getName()+" Method executed!!!");
        return returnedByMethod;
    }


}

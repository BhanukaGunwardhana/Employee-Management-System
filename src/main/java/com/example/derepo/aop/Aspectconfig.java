package com.example.derepo.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;

//import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.derepo.Exceptionhandler.EventHandleException;
@Component
@Aspect
//@Configuration

public class Aspectconfig {
    private Logger log=LoggerFactory.getLogger(Aspectconfig.class);
    @Pointcut("execution(* com.example.derepo.Controller.*.*(..))")
    public void aspectservicemethod(){}
    

     /*@Before(value="execution(* com.example.derepo.Controller.*.*(..))")
    public void logstatementBefore(JoinPoint JointPoint){
        log.info("Executing {}", JointPoint);
    }
    @After(value="execution(* com.example.derepo.Controller.*.*(..))")
    public void logstatementAfetr(JoinPoint JoinPoint){
        log.info("Completed execution{}", JoinPoint);
    }
    @Around (value="execution(* com.example.derepo.Controller.*.*(..))")
    public void measureMethodExecutionTime(ProceedingJoinPoint jp) throws Throwable{
        long start=System.nanoTime();
        Object method=jp.proceed();
        long end=System.nanoTime();
        log.info("{}", jp);
        log.info("Method execution time :"+TimeUnit.NANOSECONDS.toMillis(end-start));
        
    }*/
    @Around("aspectservicemethod()")
    public Object eventHandler(ProceedingJoinPoint jp) throws Throwable{
        try {
            return jp.proceed();
        } catch (EventHandleException e) {
            // TODO: handle exception
            log.info("eventexception", e);
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
       // return jp;

        
    }
    @Around("@annotaion(com.example.derepo.aop.Newanno)")
    //  @Around("args(String)")
    public void argmethod(JoinPoint jp){
        System.out.println(jp.getArgs());}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   

    
    
}

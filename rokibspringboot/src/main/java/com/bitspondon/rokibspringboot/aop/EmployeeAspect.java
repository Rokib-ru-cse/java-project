package com.bitspondon.rokibspringboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Date;

@Aspect
@Component
public class EmployeeAspect {
    
    @Before(value = "execution(* com.bitspondon.rokibspringboot.controller.EmployeeController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Request to "+joinPoint.getSignature()+" stated at "+new Date());
    }

    @After(value = "execution(* com.bitspondon.rokibspringboot.controller.EmployeeController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("Request to "+ joinPoint.getSignature()+" ended at "+new Date());
    }



}

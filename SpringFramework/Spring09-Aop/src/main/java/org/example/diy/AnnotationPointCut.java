package org.example.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 标识这个类是一个切面
@Aspect
public class AnnotationPointCut {
    //注解内写切入点
    @Before("execution(* org.example.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("执行前");
    }
    @Around("execution(* org.example.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("环绕前");
        Object proceed = pjp.proceed();
        System.out.println("后");
    }
}

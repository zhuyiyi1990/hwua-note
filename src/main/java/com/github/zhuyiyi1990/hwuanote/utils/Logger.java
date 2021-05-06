package com.github.zhuyiyi1990.hwuanote.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* com.github.zhuyiyi1990.hwuanote.service.impl.*.*(..))")
    private void pt1() {

    }

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的printLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的printLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。前置");
            rtValue = pjp.proceed(args);//明确调用业务层方法(切入点方法)
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。后置");
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。异常");
            throwable.printStackTrace();
        } finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。最终");
        }
        return rtValue;
    }

}

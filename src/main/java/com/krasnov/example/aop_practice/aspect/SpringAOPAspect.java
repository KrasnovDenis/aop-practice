package com.krasnov.example.aop_practice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpringAOPAspect {

    @Before("execution(* com.krasnov.example.aop_practice.old.audit.ExampleOldAudit.*(..))")
    public void basedOnRegExp() {
    }

    @Before("@annotation(com.krasnov.example.aop_practice.Loggable)")
    public void basedOnAnnotation(JoinPoint joinPoint) {
    }

    @Before("pointCutExecution()")
    public void basedOnPointCut() {
    }

    @After("pointCutExecution()")
    public void afterBasedOnPointCut() {
    }

    @AfterReturning("pointCutExecution()")
    public void afterReturningBasedOnPointCut() {
    }

    @Around("pointCutExecution()")
    public Object aroundBasedOnPointCut(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Before proceed time is - " + System.currentTimeMillis() + "ms.");
        jp.proceed();
        System.out.println("After proceed" + System.currentTimeMillis() + "ms.");
        return jp;
    }


    /**
     * <p> Ищет по имени метода (явно или по регулярке *)</p>
     * param method name by full signature
     */
    @Pointcut("execution(* com.krasnov.example.aop_practice.old.audit.ExampleOldAudit.*(..))")
    public void pointCutExecution() {
    }

    /**
     * <p> Берет все методы из данного класса (f.e. ExampleOldAudit)</p>
     * Можно также указывать с регуляркой, для пакетов
     * param classname
     */
    @Pointcut("within(com.krasnov.example.aop_practice.old.audit.ExampleOldAudit)")
    public void pointCutWithIn() {
    }

    /**
     * <p>Берет экземпляры данного объекта - можно указать интерфейс</p>
     */
    @Pointcut("target(org.slf4j.Logger)")
    public void pointCutTarget() {
    }

    /**
     * <p>То же самое как и target, но применительно к аннотациям</p>
     * param annotation
     */
    @Pointcut("@target(com.krasnov.example.aop_practice.Loggable)")
    public void pointCutTarget2() {
    }

    /**
     * <p>Берет методы, у которых совпал аргумент с экзменпляром нашего</p>
     * param classname
     */
    @Pointcut("args(java.util.List)")
    public void pointCutArgs() {
    }

    /**
     * <p>Метод, где принимается аннотация RequestParam в виде аргумента </p>
     * param annotation
     */
    @Pointcut("@args(org.springframework.web.bind.annotation.RequestParam)")
    public void pointCutArgs2() {
    }

    /**
     * <p> Ищет метод над которым стоит аннотация Loggable</p>
     * param annotation
     */
    @Pointcut("@annotation(com.krasnov.example.aop_practice.Loggable)")
    public void pointCutAnnotation2() {
    }


}

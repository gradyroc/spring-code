package cn.grady.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author gradyzhou
 * @version 1.0, on 17:11 2019/12/29.
 * 记录日志的工具类，提供了公共的代码
 */

@Component("logger")
@Aspect //表示切面
public class Logger {

    @Pointcut("execution(* cn.grady.service.impl.*.*(..))")
    private void pt1(){

    }

    /**
     * @Author: zhoup
     * @Description: 前置通知，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     * @Params:
     * @Date:
     * @return:
     */
//    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置通知 record the logs");
    }

    /**
     * @Author: zhoup
     * @Description: 后置通知
     * @Params:
     * @Date:
     * @return:
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知 record the logs");
    }

    /**
     * @Author: zhoup
     * @Description:异常通知
     * @Params:
     * @Date:
     * @return:
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知 record the logs");
    }

    /**
     * @Author: zhoup
     * @Description: 最终通知
     * @Params:
     * @Date:
     * @return:
     */
//    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("最终通知 afterPrintLog record the logs");
    }


    /**
     * @Author: zhoup
     * @Description: 环绕通知
     * 问题：1、当配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     *      通过对比动态代理中的环绕通知的代码，发现，动态代理中的环绕通知，有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     *      spring框架为我们提供了接口：ProceedinJoinPoint， proceed()方法，明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，程序执行时，spring会提供该接口的实现类共我们使用
     *
     * spring的环绕通知
     *      它是spring提供的一种可以在代码中手动控制增强方法何时执行的方式
     * @Params:
     * @Date:
     * @return:
     */
    @Around("pt1()")
    public Object arroundPrintLog(ProceedingJoinPoint joinPoint) {

        Object result = null;
        try {
            Object[] args = joinPoint.getArgs();

            System.out.println("前置通知 afterPrintLog record the logs");
            //明确调用业务层方法（切入点方法）
            result=joinPoint.proceed(args);

            System.out.println("后置通知 afterPrintLog record the logs");

        } catch (Throwable throwable) {
//            throwable.printStackTrace();
            System.out.println("异常通知 afterPrintLog record the logs");

            throw new RuntimeException(throwable);
        }finally {
            System.out.println("最终通知 afterPrintLog record the logs");
        }


        return result;

    }
}

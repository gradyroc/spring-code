package cn.grady.utils;

/**
 * @author gradyzhou
 * @version 1.0, on 17:11 2019/12/29.
 * 记录日志的工具类，提供了公共的代码
 */
public class Logger {
    /**
    *@Author: zhoup
    *@Description: 前置通知，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
    *@Params:
    *@Date:
    *@return:
    */
    public void beforePrintLog(){
        System.out.println("前置通知 record the logs");
    }

    /**
    *@Author: zhoup
    *@Description: 后置通知
    *@Params:
    *@Date:
    *@return:
    */
    public void afterReturningPrintLog(){
        System.out.println("后置通知 record the logs");
    }

    /**
    *@Author: zhoup
    *@Description:异常通知
    *@Params:
    *@Date:
    *@return:
    */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知 record the logs");
    }

    /**
    *@Author: zhoup
    *@Description: 最终通知
    *@Params:
    *@Date:
    *@return:
    */
    public void afterPrintLog(){
        System.out.println("最终通知 afterPrintLog record the logs");
    }
}

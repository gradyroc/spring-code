package cn.grady.utils;

/**
 * @author gradyzhou
 * @version 1.0, on 17:11 2019/12/29.
 * 记录日志的工具类，提供了公共的代码
 */
public class Logger {
    /**
    *@Author: zhoup
    *@Description: 计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
    *@Params:
    *@Date:
    *@return:
    */
    public void printLog(){
        System.out.println("start record the logs");
    }
}

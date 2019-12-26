package cn.grady.cglib;

import cn.grady.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gradyzhou
 * @version 1.0, on 21:07 2019/12/26.
 */
public class Client {

    public static void main(String[] args) {
        final Producer producer = new Producer();

        producer.saleProduct(1000f);

        /*
        动态代理：
            特点：字节码随用岁创建，随用随加载
            作用：不修改远吗，增强方法
            分类：
                基于子类的动态代理
                    涉及的类：Enhancer    提供者：第三方cglib库
                    如何创建代理对象：
                        Enhancer 类中的 create 方法
                    创建要求：被代理类不能是最终类，否则不能使用
                    create 方法参数：
                        Class： 字节码，指定被代理对象的字节码
                        Callback:用于提供增强的代码：写如何代理，一般都是写一个接口的实现类，通常情况都是匿名内部类，但不是必须的
                                 此接口的实现类都是谁用谁写
                                 一般写的都是该接口的子接口实现类：MethodInterceptor
                        

         */

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {

            /**
             *@Author: zhoup
             *@Description: 执行被代理对象的任何方法都会经过该方法
             *@Params:proxy：代理对象的引用
             *@Params:method：当前执行的方法
             *@Params:args：当前执行方法的参数
             * 以上3个参数和基于接口的动态代理参数一样
             *@Params:methodProxy：当前执行方法的代理对象
             *
             *@Date:
             *@return:
             */
            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object result = null;
                //1.获取方法执行的参数
                Float money = (Float) args[0];
                //2.判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    result = method.invoke(producer, money * 0.8f);
                }
                return result;
            }
        });

        cglibProducer.saleProduct(1000f);
    }
}

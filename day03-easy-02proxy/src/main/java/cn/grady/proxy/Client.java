package cn.grady.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gradyzhou
 * @version 1.0, on 21:07 2019/12/26.
 */
public class Client {

    public static void main(String[] args) {
        Producer producer = new Producer();

        producer.saleProduct(1000f);

        /*
        动态代理：
            特点：字节码随用岁创建，随用随加载
            作用：不修改远吗，增强方法
            分类：
                基于接口的动态代理
                    涉及的类：Proxy    提供者：JDK官方
                    如何创建代理对象：
                        Proxy类中的newProxyInstance 方法
                    创建要求：呗代理类最少实现一个接口，否则不能使用
                    newProxyInstance参数：
                        ClassLoader:类加载器，用于加载代理对象字节码的，和被代理对象使用相同的类加载器,固定写法
                        Class[]：字节码数组，让代理对象和被代理对象有相同方法,写法固定
                        InvocationHandler：用于提供增强的代码：写如何代理，一般都是写一个接口的实现类，通常情况都是匿名内部类，但不是必须的
                                            此接口的实现类都是谁用谁写

                基于自子类的动态代理


         */

        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {

                    /**
                     *@Author: zhoup
                     *@Description: 执行被代理对象的任何接口方法都会经过该方法
                     *@Params:proxy：代理对象的引用
                     *@Params:method：当前执行的方法
                     *@Params:args：当前执行方法的参数
                     *@Date:
                     *@return: 和被代理对象方法有相同的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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

        proxyProducer.saleProduct(1000f);
    }
}

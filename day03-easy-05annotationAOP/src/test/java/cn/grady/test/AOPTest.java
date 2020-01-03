package cn.grady.test;

import cn.grady.service.IAccountServiceAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gradyzhou
 * @version 1.0, on 17:47 2019/12/29.
 * 测试Aop配置
 */
public class AOPTest {

    public static void main(String[] args) {
        //获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //获取对象
        IAccountServiceAdvice as = (IAccountServiceAdvice) ac.getBean("accountServiceAnnotationAOP");
        //
        as.saveAccount();
//        as.updateAccount(0);
//        as.deleteAccount();
    }

}

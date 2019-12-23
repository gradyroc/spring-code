package cn.grady.daotest.service.impl;


import cn.grady.daotest.dao.impl.IAccountDaoImpl;
import cn.grady.daotest.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author gradyzhou
 * @version 1.0, on 21:34 2019/9/19.
 */
/*
账户的业务层实现类

曾经的xml配置
 <bean id="accountService" class="cn.grady.cn.grady.daotest.service.impl.AccountServiceImpl"
    scope="" init-method="" destroy-method="">
        <property name="" value="" ref=""></property>


    </bean>

用于创建对象的
    相当于xml中<bean>相同
    @Component:
        将对象存入spring容器（map结构，k，v）
        属性：
            value：用于指定bean的ID，当我们不写时，默认值为当前类名，且首字母小写

    @Controller： 表现层

    @Service：业务层
    @Repository：持久层

    以上3个注解作用和属性与Component一模一样，
    是spring框架提供的明确的3层使用的注解，使三层对象更加清晰

用于注入数据的
   bean标签中 <property>标签作用一样
    @Autowired
        自动按照类型注入，只要容器中有位移的bean对象类型和要注入的变量类型匹配，就可以注入成功
                        如果ioc容器中没有任何ban类型和要注入的变量类型匹配，则报错
                        如果IOC容器中有多个类型可以匹配，则先根据类型，再根据变量名名称和bean的ID匹配

        出现位置：
            变量、方法上
         细节：使用注解注入时，set方法就不是必须的了
     @Qualifier:
        在按照类中注入的基础之上再按照名称注入，给类成员注入时不能单独使用，给方法参数注入时可以
        属性：
            value：用于指定注入bean的ID
      @Resource:
        作用：直接按照bean的ID注入，可以独立使用
        属性：
            name，用于指定bean的ID
    以上3个注解都只能注入其他bean类型的护具，而基本类型和String类型㞏使用上述注解实现
    另外，集合类型的注入只能通过xml来实现


    @Value
        作用：用于注入基本类型和String类型的数据
        属性：
            value，指定数据的值，可以使用spring中的SpEL（spring中的el表达式）
                SpEL的写法：${表达式}


用于改变作用范围的
    bean标签中 scope属性相同
    Scope：
        指定bean的作用范围
       属性：
        value：指定范围的取值，常用取值，singleton，prototype
            默认为单例




和生命周期相关的
    和bean标签中 init-method 和 destory-mehod 作用一样


    @PreDestroy
         用于指定销毁方法
    @PostConstruct
        用于指定初始化方法
 */


//@Component
//@Component("accountServiceImpl")
//@Service
@Service(value = "accountService")
//@Scope("protoype")//多例，spring不管销毁，jvm垃圾回收
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("account1")
    private IAccountDaoImpl accountDao1;


    @Autowired
    @Qualifier("account2")
    private IAccountDaoImpl accountDao2;

    @Override
    public void saveAccount(String name) {
        accountDao1.saveAccount(name);
        System.out.println(accountDao1);

    }

    @Override
    public void saveAccount2(String name) {
        accountDao2.saveAccount(name);
        System.out.println(accountDao2);
    }
}

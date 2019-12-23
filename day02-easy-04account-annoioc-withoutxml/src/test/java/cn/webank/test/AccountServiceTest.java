package cn.webank.test;

import cn.webank.config.JdbcConfiguration;
import cn.webank.config.SpringConfiguration;
import cn.webank.domain.Account;
import cn.webank.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 22:51 2019/12/16.
 *
 * Spring 整合junit的配置
 *  1、导入spring整合junit的jar包
 *  2、使用junit提供的注解把原有的main方法替换成spring提供的
 *      @Runwith
 *
 *  3、告知spring的运行期，spring的ioc创建是基于xml 的还是注解的，并且说明位置
 *      @ContextConfiguration
 *          locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *          classes:指定注解类所在的 位置
 *
 *  当使用spring5.x版本的时候，要求junit的版本必须在4.12以上
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private ApplicationContext ac;

    private IAccountService as;

//    @Before  需要写的初始化方法
    public void init() {
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfiguration.class);
        as = ac.getBean("accountServer", IAccountService.class);
    }

    @Test
    public void testFindAll() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);


        List<Account> accountList = as.findAllAccount();
        accountList.forEach(account -> System.out.println(account));
    }

    @Test
    public void testFindOne() {

    }

    @Test
    public void testSave() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}

package cn.webank.test;

import cn.webank.config.SpringConfiguration;
import cn.webank.domain.Account;
import cn.webank.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 22:51 2019/12/16.
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IAccountService as = ac.getBean("accountServer", IAccountService.class);

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

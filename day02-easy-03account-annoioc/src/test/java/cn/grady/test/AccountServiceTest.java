package cn.grady.test;

import cn.grady.domain.Account;
import cn.grady.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 22:51 2019/12/16.
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

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

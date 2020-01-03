package cn.grady.service.impl;

import cn.grady.service.IAccountServiceAdvice;
import org.springframework.stereotype.Service;

/**
 * @author gradyzhou
 * @version 1.0, on 17:10 2019/12/29.
 * 账户的业务层实现类
 */
@Service("accountServiceAnnotationAOP")
public class AccountServiceAdvice implements IAccountServiceAdvice {

    @Override
    public void saveAccount() {
        System.out.println(" AccountService save method");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("update method");

    }

    @Override
    public int deleteAccount() {

        System.out.println("delete method");


        return 0;
    }
}

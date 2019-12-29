package cn.grady.service.impl;

import cn.grady.dao.IAcountDao;
import cn.grady.domain.Account;
import cn.grady.service.IAccountService;
import cn.grady.utils.TransactionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 22:53 2019/11/5.
 */
@Slf4j
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private IAcountDao accountDao;

//    @Autowired
//    private TransactionManager transactionManager;


    public IAcountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAcountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByID() {

        //2、执行操作
        Account account = accountDao.findAccountByID(0);

        return account;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountID) {
        accountDao.deleteAccount(accountID);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //2、执行操作
        System.out.println("transfer");
        //        1、根据名称查询转出账户
        Account source = accountDao.findAccontByName(sourceName);

//        2、根据名称查询转入账户
        Account target = accountDao.findAccontByName(targetName);
//        3、转出账户捡钱
        source.setMoney(source.getMoney() - money);
//        4、转入账户加钱
        target.setMoney(source.getMoney() + money);
//        5、更新转出账户
        accountDao.updateAccount(source);
//        6、更新转入账户
        accountDao.updateAccount(target);


    }
}

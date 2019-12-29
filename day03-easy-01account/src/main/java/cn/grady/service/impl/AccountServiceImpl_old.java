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
public class AccountServiceImpl_old implements IAccountService {


    @Autowired
    private IAcountDao accountDao;

    @Autowired
    private TransactionManager transactionManager;


    public IAcountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAcountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1、开启事务
            transactionManager.beginTransaction();
            //2、执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3、提交事务
            transactionManager.commit();
            //4、返回结果
            return accounts;
        } catch (Exception e) {

            //5、回滚
            transactionManager.rollback();

        } finally {

            //6、释放资源
            transactionManager.release();
        }
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByID() {
        try {
            //1、开启事务
            transactionManager.beginTransaction();
            //2、执行操作
            Account account = accountDao.findAccountByID(0);
            //3、提交事务
            //4、返回结果

            return account;

        } catch (Exception e) {

            //5、回滚

        } finally {

            //6、释放资源
        }
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1、开启事务
            //2、执行操作
            //3、提交事务
            //4、返回结果
        } catch (Exception e) {

            //5、回滚

        } finally {

            //6、释放资源
        }
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
//
        try {
            //1、开启事务
            transactionManager.beginTransaction();
            //2、执行操作
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
            //3、提交事务
            transactionManager.commit();
            //4、返回结果
        } catch (Exception e) {

            //5、回滚
            transactionManager.rollback();

        } finally {

            //6、释放资源
            transactionManager.release();
        }


    }
}

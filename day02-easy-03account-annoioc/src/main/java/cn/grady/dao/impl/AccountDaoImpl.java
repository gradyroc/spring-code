package cn.grady.dao.impl;

import cn.grady.dao.IAcountDao;
import cn.grady.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 22:59 2019/11/5.
 */

@Slf4j
@Repository("accountDao")
public class AccountDaoImpl implements IAcountDao {


    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
//        log.info("findAllAccount.......");
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByID(int accountID) {
        try {
            return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),accountID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
             runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountID) {
        try {
            runner.update("delete from account  where id=?",accountID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

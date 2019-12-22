package cn.webank.dao.impl;

import cn.webank.dao.IAcountDao;
import cn.webank.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 22:59 2019/11/5.
 */

@Slf4j
public class AccountDaoImpl implements IAcountDao {


    private QueryRunner runner;

    public QueryRunner getRunner() {
        return runner;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

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

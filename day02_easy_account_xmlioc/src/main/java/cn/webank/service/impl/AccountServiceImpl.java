package cn.webank.service.impl;

import cn.webank.dao.IAcountDao;
import cn.webank.domain.Account;
import cn.webank.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author gradyzhou
 * @version 1.0, on 22:53 2019/11/5.
 */
@Slf4j
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private IAcountDao accountDao;

    public IAcountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAcountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        accountDao.findAllAccount();
        return null;
    }

    @Override
    public Account findAccountByID() {
        accountDao.findAccountByID(0);
        return null;
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
}

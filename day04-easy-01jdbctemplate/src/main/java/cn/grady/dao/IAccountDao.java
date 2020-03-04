package cn.grady.dao;

import cn.grady.domain.Account;

/**
 * @author gradyzhou
 * @version 1.0, on 16:07 2020/1/4.
 * 持久层
 */
public interface IAccountDao {

    Account findAccountById(Integer id );
}

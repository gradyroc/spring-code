package cn.grady.service;

import cn.grady.domain.Account;

import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 22:45 2019/11/5.
 */
public interface IAccountService {

    /**
    *@Author: zhoup
    *@Description:查询所有
    *@Params:
    *@Date:
    *@return:
    */
    List<Account> findAllAccount();

    /**
    *@Author: zhoup
    *@Description: 查询一个
    *@Params:
    *@Date:
    *@return:
    */
    Account findAccountByID();


    /**
    *@Author: zhoup
    *@Description:保存
    *@Params:
    *@Date:
    *@return:
    */
    void saveAccount(Account account);

    /**
    *@Author: zhoup
    *@Description:更新
    *@Params:
    *@Date:
    *@return:
    */
    void updateAccount(Account account);


    /**
    *@Author: zhoup
    *@Description:删除
    *@Params:
    *@Date:
    *@return:
    */
    void deleteAccount(Integer accountID);

}

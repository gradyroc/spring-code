package cn.grady.service;

/**
 * @author gradyzhou
 * @version 1.0, on 17:08 2019/12/29.
 * 账户的业务层接口
 */
public interface IAccountService {

    /*
    模拟保存账户
     */
    void saveAccount();

    /**
    *@Author: zhoup
    *@Description: 模拟更新
    *@Params:
    *@Date:
    *@return:
    */
    void updateAccount(int i );

    /**
    *@Author: zhoup
    *@Description: 删除
    *@Params:
    *@Date:
    *@return:
    */
    int deleteAccount();

}

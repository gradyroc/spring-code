package cn.grady.daotest.dao.impl;

import cn.grady.daotest.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author gradyzhou
 * @version 1.0, on 22:35 2019/11/4.
 */

@Repository("accountDao2")
public class IAccountDaoImpl2 implements IAccountDao {

    @Override
    public void saveAccount() {

        System.out.println("saveAccount IAccountDaoImpl2");
    }
}

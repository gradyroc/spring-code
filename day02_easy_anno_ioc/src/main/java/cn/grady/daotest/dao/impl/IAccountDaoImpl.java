package cn.grady.daotest.dao.impl;

import cn.grady.daotest.dao.IAccountDao;
import lombok.Data;
import org.springframework.stereotype.Repository;


/**
 * @author gradyzhou
 * @version 1.0, on 22:35 2019/11/4.
 */
/*
持久层
 */
@Repository("accountDao")
@Data
public class IAccountDaoImpl implements IAccountDao {

    @Override
    public void saveAccount() {


        System.out.println("saveAccount  IAccountDaoImpl");
    }
}

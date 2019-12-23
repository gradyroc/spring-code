package cn.grady.daotest.dao.impl;

import cn.grady.daotest.dao.IAccountDao;
import lombok.Data;


/**
 * @author gradyzhou
 * @version 1.0, on 22:35 2019/11/4.
 */
/*
持久层
 */
@Data
public class IAccountDaoImpl implements IAccountDao {

    public String name;

    @Override
    public void saveAccount(String  name) {
        this.name = name;
        System.out.println("saveAccount  name:"+name);
    }
}

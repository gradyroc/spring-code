package cn.grady.dao.impl;

import cn.grady.dao.IAccountDao;
import cn.grady.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gradyzhou
 * @version 1.0, on 16:09 2020/1/4.
 */
public class AccountDaoImpl2 implements IAccountDao {

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer id) {
        return null;
    }
}

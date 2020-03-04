package cn.grady.dao.impl;

import cn.grady.dao.IAccountDao;
import cn.grady.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 16:09 2020/1/4.
 */
//spring 自带的有
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer id) {

        List<Account> accounts = super.getJdbcTemplate().query("", new BeanPropertyRowMapper<>(Account.class));
        return null;
    }
}

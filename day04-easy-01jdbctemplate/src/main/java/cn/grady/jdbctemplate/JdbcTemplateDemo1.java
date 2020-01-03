package cn.grady.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gradyzhou
 * @version 1.0, on 22:48 2020/1/3.
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        JdbcTemplate jt = new JdbcTemplate();

        jt.execute("insert into account(name,money) values('ccc',1000)");
    }
}

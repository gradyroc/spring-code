package cn.grady.daotest.config;

import cn.grady.daotest.dao.impl.IAccountDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gradyzhou
 * @version 1.0, on 15:13 2019/12/13.
 */
@Configuration
public class BeanConfig {

    @Bean(name = "account1")
    public IAccountDaoImpl getIAccountDao1(){
        return new IAccountDaoImpl();
    }
    @Bean(name = "account2")
    public IAccountDaoImpl getIAccountDao2(){
        return new IAccountDaoImpl();
    }
}

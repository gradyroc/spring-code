package cn.webank.config;

/**
 * @author gradyzhou
 * @version 1.0, on 17:14 2019/12/22.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
*@Author: zhoup
*@Description:  数据库相关的配置
*@Params:
*@Date:
*@return:
*/
@Configuration
public class JdbcConfiguration {


    @Value("${jdb.driver}")
    private String jdbcDriver;

    @Value("${jdb.url}")
    private String url;

    @Value("${jdb.username}")
    private String username;

    @Value("${jdb.password}")
    private String password;



    //@Bean注解的作用，把当前方法的返回值作为bean对象，放入spring的ioc容器中==>等价于bean.xml
    //  属性：name=指定bean的id，默认值是当前方法的名称,
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * @Author: zhoup
     * @Description: 创建DataSource
     * @Params:
     * @Date:
     * @return:
     */
    @Bean(name = "dataSource")
    @Scope("prototype")
    public DataSource createDataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(jdbcDriver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

}

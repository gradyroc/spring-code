package cn.webank.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author gradyzhou
 * @version 1.0, on 23:43 2019/12/18.
 * 该类是个配置类
 * spring中的新注解
 * Configuration：指定当前类是个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注释可以不写
 * ComponentScan: 指定spring创建容器时要扫描的包
 * 属性：
 * value： 和basePackages的作用是一样的，都是指定spring创建容器时要扫描的包
 * 使用这个注解就等同于在xml中配置了
 * <!--    告知spring在创建容器时要扫描的包-->
 * <context:component-scan base-package="cn.webank"></context:component-scan>
 * <p>
 * 当使用注解配置方法时，如果方法有参数，spring去容器中查找有没有可用的bean对象
 * 查找方式的方式和Autowired注解的作用是一样的，
 */




@Configuration
@ComponentScan(basePackages = "cn.webank")
//@ComponentScan("cn.webank")
public class SpringConfiguration {

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
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/easy");
            dataSource.setUser("root");
            dataSource.setPassword("1234");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}

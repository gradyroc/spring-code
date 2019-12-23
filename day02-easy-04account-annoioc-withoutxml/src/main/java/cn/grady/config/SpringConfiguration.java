package cn.grady.config;

import org.springframework.context.annotation.*;

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
 * <context:component-scan base-package="cn.grady"></context:component-scan>
 * <p>
 * 当使用注解配置方法时，如果方法有参数，spring去容器中查找有没有可用的bean对象
 * 查找方式的方式和Autowired注解的作用是一样的，
 *
 *注解 Import
 *      用于导入其他配置类
 *   属性：value:指定其他配置类的字节码
 *      当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的都是子配置类
 *
 *
 *注解： PropertySource:用于指定properties文件的位置
 *      属性：value:用于指定文件的名称和路径
 *          关键之：classpath：表是类路径
 */



@Configuration
@ComponentScan(basePackages = "cn.grady")
//@ComponentScan("cn.grady")
@Import(JdbcConfiguration.class)//导入其他配置类到主配置类，分配置文件的编写
@PropertySource("classpath:jdbcConfig.properties")//可以指定resources下的路径
public class SpringConfiguration {

//   数据库链接的配置全部转移到JdbcConfiguration类中
}

package cn.webank.test;

import cn.webank.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gradyzhou
 * @version 1.0, on 22:12 2019/12/20.
 */
public class QuryRunnerTest {

    @Test
    public void testQueryRunner(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);

        System.out.println(runner==runner1);

    }
}

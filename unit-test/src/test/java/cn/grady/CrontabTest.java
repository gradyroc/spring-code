package cn.grady;

import org.junit.Test;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import static java.lang.Thread.sleep;

/**
 * @author gradyzhou
 * @version 1.0, on 16:01 2020/3/15.
 */
public class CrontabTest {

    @Scheduled(cron = "* 0/1 16 * * *")
    public void crontabTest(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
    }

    public static void main(String[] args) throws InterruptedException {
        sleep(1000000000);
    }
}

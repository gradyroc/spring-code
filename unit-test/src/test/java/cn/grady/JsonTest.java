package cn.grady;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author gradyzhou
 * @version 1.0, on 17:19 2020/1/13.
 */

public class JsonTest {

    @Test
    public void jsonDataTest(){
        String data= "\"a\":\"www\",\"b\":\"ssss\"";
        JSONObject jsonObject = JSON.parseObject(data);
        System.out.println("over");
    }
}

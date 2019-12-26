package cn.grady.cglib;

import cn.grady.proxy.IProducer;

/**
 * @author gradyzhou
 * @version 1.0, on 20:50 2019/12/26.
 */
public class Producer  {

    /**
     * @Author: zhoup
     * @Description: 销售
     * @Params:
     * @Date:
     * @return:
     */
    public void saleProduct(float money) {
        System.out.println("sale product,get money:" + money);
    }

    /**
     * @Author: zhoup
     * @Description: 售后
     * @Params:
     * @Date:
     * @return:
     */
    public void afterService(float money) {

        System.out.println("after sale,get money:" + money);
    }
}

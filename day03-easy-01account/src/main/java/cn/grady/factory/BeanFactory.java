package cn.grady.factory;

import cn.grady.domain.Account;
import cn.grady.service.IAccountService;
import cn.grady.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author gradyzhou
 * @version 1.0, on 23:12 2019/12/26.
 * 用于创建Service代理对象的工厂
 */
public class BeanFactory {


    private IAccountService accountService;

    private TransactionManager transactionManager;

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * @Author: zhoup
     * @Description: 获取service代理对象
     * @Params:
     * @Date:
     * @return:
     */
    public IAccountService getAccountService() {

        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     *@Author: zhoup
                     *@Description: 添加事务的支持
                     *@Params:
                     *@Date:
                     *@return:
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            //1、开启事务
                            transactionManager.beginTransaction();
                            //2、执行操作
                            result = method.invoke(accountService, args);
                            //3、提交事务
                            transactionManager.commit();
                        } catch (Exception e) {

                            //5、回滚
                            transactionManager.rollback();

                        } finally {

                            //6、释放资源
                            transactionManager.release();
                        }
                        //4、返回结果
                        return result;
                    }
                });

    }

}

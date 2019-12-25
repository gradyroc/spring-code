package cn.grady.utils;

import java.sql.SQLException;

/**
 * @author gradyzhou
 * @version 1.0, on 23:16 2019/12/25.
 * 事务管理工具类，包含开启、提交、回滚和释放链接
 */
public class TransactionManager {

    public ConnectionUtils getConnUtils() {
        return connUtils;
    }

    public void setConnUtils(ConnectionUtils connUtils) {
        this.connUtils = connUtils;
    }

    private ConnectionUtils connUtils;

    /**
    *@Author: zhoup
    *@Description:开启事务
    *@Params:
    *@Date:
    *@return:
    */
    public void beginTransaction(){
        try {
            connUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *@Author: zhoup
     *@Description:提交事务
     *@Params:
     *@Date:
     *@return:
     */
    public void commit(){
        try {
            connUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *@Author: zhoup
     *@Description:回滚事务
     *@Params:
     *@Date:
     *@return:
     */
    public void rollback(){
        try {
            connUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *@Author: zhoup
     *@Description:释放链接
     *@Params:
     *@Date:
     *@return:
     */
    public void release(){
        try {
            connUtils.getThreadConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

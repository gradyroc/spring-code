package cn.grady.utils;


import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author gradyzhou
 * @version 1.0, on 23:06 2019/12/25.
 * 工具类，并实现链接和线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;

    public Connection getThreadConnection() {
        //1:先从ThreadLocal上获取
        Connection conn = tl.get();

        try {

            if (conn == null) {
                //3、从数据源获取链接，并绑定threadLocal
                conn = dataSource.getConnection();
                tl.set(conn);
            }

            //4:返回当前线程上的链接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Author: zhoup
     * @Description: 链接和线程解绑
     * @Params:
     * @Date:
     * @return:
     */
    public void removeConnection() {
        tl.remove();
    }


}

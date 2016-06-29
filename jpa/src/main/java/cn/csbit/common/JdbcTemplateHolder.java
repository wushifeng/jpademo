package cn.csbit.common;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTemplateHolder extends org.springframework.jdbc.core.JdbcTemplate {

    public JdbcTemplateHolder() {
        super();
    }

    public JdbcTemplateHolder(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * 此方法在执行sql语句时打开连接
     */
    public final static JdbcTemplateHolder getTemplate(String ip, int port, byte type, String dbName, String userName,
                                                       String password) {
        return getCoreTemplate(new DriverManagerDataSource(), ip, port, type, dbName, userName, password);// 执行完sql语句后connection自动关闭
    }

    public final static JdbcTemplateHolder getTemplateSingle(String ip, int port, byte type, String dbName, String userName,
                                                             String password) {
        return getCoreTemplate(new SingleConnectionDataSource(), ip, port, type, dbName, userName, password);// connection需要手动关闭，多语句执行时可已提高效率
    }

    public static final void test(String ip, int port, byte type, String dbName, String userName, String password) {
        JdbcTemplateHolder template = getTemplateSingle(ip, port, type, dbName, userName, password);
        try {
            Connection connection = template.getDataSource().getConnection();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("连接失败", e);
        }
    }

    /**
     * zh 获取sqlite连接，不需要手动关闭
     *
     * @param path
     * @return
     */
    public static final JdbcTemplateHolder getSqlite(String path) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:/" + path);
        return new JdbcTemplateHolder(dataSource);
    }

    private final static JdbcTemplateHolder getCoreTemplate(DriverManagerDataSource info, String ip, int port, byte type,
                                                            String dbName, String userName, String password) {
        StringBuilder url = new StringBuilder();
        switch (type) {
            case Global.DbType.ORACLE:// oracle
                info.setDriverClassName("oracle.jdbc.driver.OracleDriver");
                url.append("jdbc:oracle:thin:@").append(ip).append(":").append(port).append(":").append(dbName);
                break;
            case Global.DbType.MSSQL:// MSSql jtds 在java8下出现connect reset
                // info.setDriver("net.sourceforge.jtds.jdbc.Driver");
                // url.append("jdbc:jtds:sqlserver://").append(ip).append(":").append(port);
                info.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                url.append("jdbc:sqlserver://").append(ip).append(":").append(port);
                if (dbName == null)
                    dbName = "master";
                url.append(";databaseName=").append(dbName).append(";ssl=request;");
                break;
            case Global.DbType.DB2:// DB2
                info.setDriverClassName("com.ibm.db2.jcc.DB2Driver");
                url.append("jdbc:db2://").append(ip).append(":").append(port).append("/").append(dbName);
                break;
            case Global.DbType.MYSQL:// MySql
                info.setDriverClassName("com.mysql.jdbc.Driver");
                url.append("jdbc:mysql://").append(ip).append(":").append(port).append("/").append(dbName);
                break;
            case Global.DbType.CACHE:// Cache
                break;
            case Global.DbType.SYBASE:// Sysbase
                info.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
                url.append("jdbc:jtds:sybase://").append(ip).append(":").append(port);
                break;
            case Global.DbType.DAMENG:// dameng7
                info.setDriverClassName("dm.jdbc.driver.DmDriver");
                url.append("jdbc:dm://").append(ip).append(":").append(port).append("/").append(dbName);
                break;
            case Global.DbType.Informix:
                info.setDriverClassName("com.informix.jdbc.IfxDriver");
                // url.append("jdbc:informix-sqli://").append(ip).append(":").append(port).append("/").append(dbName);//dbName样式：实例名:informixserver=服务器名
                url.append("jdbc:informix-sqli://").append(ip).append(":").append(port).append("/sysmaster:informixserver=")
                        .append(dbName);// 默认都用sysmaster吧，出问题再讨论；
                break;
            case Global.DbType.DAMENG6:// dameng6
                info.setDriverClassName("dm6.jdbc.driver.DmDriver");
                url.append("jdbc:dm6://").append(ip).append(":").append(port).append("/").append(dbName);
                break;
            default:
                throw new RuntimeException("暂不支持此类型的数据库");
        }
        info.setUrl(url.toString());
        info.setUsername(userName);
        info.setPassword(password);
        return new JdbcTemplateHolder(info);
    }

    /**
     * 原有方法查询结果为空时抛出异常
     */
    @Override
    public <T> T queryForObject(String sql, Class<T> requiredType, Object... args) throws DataAccessException {
        try {
            return super.queryForObject(sql, requiredType, args);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer queryForInt(String sql, Object... args) {
        return this.queryForObject(sql, Integer.class, args);
    }

    public Long queryForLong(String sql, Object... args) {
        return this.queryForObject(sql, Long.class, args);
    }

}

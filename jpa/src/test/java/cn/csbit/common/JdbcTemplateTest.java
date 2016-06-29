package cn.csbit.common;

import cn.csbit.BaseTest;
import cn.csbit.model.User;
import cn.csbit.repository.UserDao;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by wushifeng on 2016/6/28.
 */
public class JdbcTemplateTest extends BaseTest {
    @Value("${jdbc.username}")
    String userName;
    @Value("${jdbc.defaultCatalog}")
    String lib;
    @Value("${jdbc.password}")
    String passwd;

    @Autowired
    UserDao dao;
    Integer lastId;

    @BeforeClass
    public static void init() {
    }

    @org.junit.Before
    public void setUp() throws Exception {
        Log.i(this.userName);

        dao.deleteAll();

        User u = new User();
        u.setName("usr1");
        dao.save(u);

        u = new User();
        u.setName("usr2");
        dao.save(u);

        this.lastId = u.getId();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    //本身的数据库直连情况的测试
    JdbcTemplateHolder getJdbc() {
        JdbcTemplateHolder j;
        if (System.getProperty("spring.profiles.active") == "production")
            j = JdbcTemplateHolder.getTemplate("localhost", 3306, Global.DbType.MYSQL, this.lib, this.userName, this.passwd);
        else {
            DataSource ds = SpringContextHolder.getBean("dataSource");
            j = new JdbcTemplateHolder(ds);
        }
        return j;
    }

    @Test
    public void testJdbcImportData() {
        if (System.getProperty("spring.profiles.active") != "production") {
            DataSource ds = SpringContextHolder.getBean("dataSource");
            JdbcTemplateHolder j = new JdbcTemplateHolder(ds);
            Assert.assertTrue(j.queryForInt("select count(*) from demo_init") > 0);
        } else
            Assert.assertTrue("测试启动导入初始数据", true);
    }

    @Test
    public void testCount() {
        JdbcTemplateHolder j = this.getJdbc();
        Integer n = j.queryForInt("select count(1) from  user");
        Assert.assertTrue(n == 2);
    }

    @Test
    public void testGetList() {
        JdbcTemplateHolder j = this.getJdbc();
        BeanPropertyRowMapper rowMap = new BeanPropertyRowMapper(User.class);
        List<User> ls = j.query("select * from user", rowMap);
        Assert.assertTrue(ls.size() == 2);

        ls = j.query("select * from user where id=?", rowMap, this.lastId);
        Assert.assertTrue(ls.size() == 1);
    }

    @Test
    public void testGetOtherObject() {
        JdbcTemplateHolder j = this.getJdbc();
        //获取单列的::强烈不建议拼接字符串
        String name = j.queryForObject("select name from user where id=" + this.lastId, String.class);
        Assert.assertTrue(name != null);

        name = j.queryForObject("select name from user where id = ?", new Object[]{this.lastId}, String.class);
        Log.i(name);
        Assert.assertTrue(name != null);
    }

    @Test
    public void testGetObject() {
        JdbcTemplateHolder j = this.getJdbc();
        BeanPropertyRowMapper rowMap = new BeanPropertyRowMapper(User.class);
        User u = (User) j.queryForObject("select * from user where id = ?", new Object[]{this.lastId}, rowMap);
        Assert.assertTrue(u != null);
    }
}

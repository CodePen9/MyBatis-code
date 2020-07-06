import com.jiang.dao.UserDao;
import com.jiang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Title:
 * @author: JiangPeng
 */
public class test01 {

    @Test
    public void getUserList() throws IOException {
        /*
            根据全局配置文件创建出一个SqlSessionFactory
            SqlSessionFactory：是SqlSession工厂，负责创建SqlSession
         */
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //通过sqlSessionFactory.openSession()获取和数据库的一次会话
        //底层就是getConnection拿到一条连接
        SqlSession openSession = sqlSessionFactory.openSession();

        //使用SqlSession操作数据库，获取到Dao接口的实现
        UserDao userDao = openSession.getMapper(UserDao.class);
        //直接调用写的方法
        List<User> userList = userDao.getUserList();
        for (User user:userList) {
            System.out.println(user);
        }
        //每一次获取openSession相当于一条连接，资源宝贵，用完关闭
        openSession.close();
    }
}

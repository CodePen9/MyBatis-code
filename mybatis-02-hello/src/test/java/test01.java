import com.jiang.dao.UserDao;
import com.jiang.pojo.User;
import com.jiang.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
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
    public void getUser() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
    }
    @Test
    public void updateUser() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        int i = mapper.updateUser(new User(1, "PWP", "jiang2020"));
        System.out.println(i);
        sqlSession.commit();
    }
    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int i = mapper.addUser(new User("Nginx", "abc123"));
            if(i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败请检查后重试");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }


        //ALTER TABLE table_name AUTO_INCREMENT = 1;
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUser(6);
        sqlSession.commit();
    }
}

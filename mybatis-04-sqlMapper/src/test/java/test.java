import com.jiang.dao.UserDao;
import com.jiang.pojo.User;
import com.jiang.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Title:
 * @author: JiangPeng
 */
public class test {

    @Test
    public void getUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        System.out.println(userList);
    }
}

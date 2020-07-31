package color.purple.test;

import color.purple.dao.impl.UserDaoImpl;
import color.purple.domain.User;
import color.purple.service.impl.UserServiceImpl;
import color.purple.utils.JDBCUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test {

    @Before
    public void start() {
        System.out.println("start");
    }

    @Test
    public void test1() {
        try {
            System.out.println(JDBCUtils.getDataSource());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void insert() throws Exception {
        /**/
    }

    @Test
    public void login() {
        System.out.println(new UserDaoImpl().getMaxUsername());
    }

    @Test
    public void add() {
        User user = new User();
        user.setQq("25645157");
        user.setName("latina");
        user.setAddress("ALE");
        user.setGender("female");
        user.setAge(12);
        user.setEmail("645713@qq.com");
//        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.add(user));
        for (int i = 0; i < 40; i++) {
            System.out.println("第" + i + "次:" + new UserServiceImpl().addUser(user));
        }

    }


    @Test
    public void update() {
        User user = new User();
        user.setQq("25645157");
        user.setName("Catalina");
        user.setAddress("ALE");
        user.setGender("female");
        user.setAge(12);
        user.setEmail("645713@qq.com");
        user.setId(10);
        System.out.println(new UserServiceImpl().updateUser(user));
    }

    @Test
    public void count() {
//        System.out.println(new UserDaoImpl().totalCount(condition));
    }

    @After
    public void end() {
        System.out.println("end");
    }

}

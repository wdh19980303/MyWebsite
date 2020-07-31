package color.purple.web.test;

import color.purple.web.Dao.UserDao;
import color.purple.web.User.User;
import jdk.jfr.StackTrace;
import org.junit.Test;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.print.attribute.standard.JobOriginatingUserName;

public class test {
    @Test
    public void test() {
        User loginUser = new User();
        loginUser.setUsername("alice");
        loginUser.setPassword("0000");
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
//        System.out.println(user);

    }
}

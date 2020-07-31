package color.purple.web.Dao;

import color.purple.web.JDBCUtils.JDBCUtils;
import color.purple.web.User.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser) {
        String sqlLogin = "select * from user where username = ? and password = ? ";
        User user = null;
        try {
            user = template.queryForObject(sqlLogin, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

}

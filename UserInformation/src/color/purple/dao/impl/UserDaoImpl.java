package color.purple.dao.impl;

import color.purple.dao.UserDao;
import color.purple.domain.User;
import color.purple.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        // 使用jdbc操作数据
        // 1 定义sql
        String sqlFindAll = "select * from user";
        List<User> users = template.query(sqlFindAll, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(User user) {
        String sql = "insert into user (name,age,address,qq,email,gender,username,password) value (?,?,?,?,?,?,?,?)";
        int max = getMaxUsername() + 1;
        return template.update(sql, user.getName(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getGender(), max, "0000");

    }

    @Override
    public int getMaxUsername() {
        String sql = "select MAX(username) from user";
        return template.queryForObject(sql, new Object[]{}, Integer.class);
    }

    @Override
    public int del(int id) {
        String sql = "delete from user where id = ?";
        return template.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public int update(User user) {
        String sql = "update user set name = ? , age = ?, address = ?, qq = ?, email = ?, gender = ? where id = ?";
        return template.update(sql, user.getName(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getGender(), user.getId());
    }

    @Override
    public int totalCount(Map<String, String[]> condition) {
        // 定义sql模板
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        // 遍历condition中的参数
        Set<String> keys = condition.keySet();
        for (String key : keys) {
            String value = condition.get(key)[0];
            if (key.equals("currentPage") || key.equals("rows")) continue;
            // 判断是否空值
            if (value != null && !"".equals(value) ) {
                stringBuilder.append(" AND ").append(key).append(" LIKE  ? ");
                params.add("%" + value + "%");
            }
        }
//        System.out.println(stringBuilder.toString());
//        System.out.println(params);

        return template.queryForObject(stringBuilder.toString(), Integer.class,params.toArray());

    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
//        String sql = "select * from user limit ? , ?";
        String sql = "select * from user where 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        // 遍历condition中的参数
        Set<String> keys = condition.keySet();
        for (String key : keys) {
            String value = condition.get(key)[0];
            if (key.equals("currentPage") || key.equals("rows")) continue;
            // 判断是否空值
            if (value != null && !"".equals(value) ) {
                stringBuilder.append(" AND ").append(key).append(" LIKE ? ");
                params.add("%" + value + "%");
            }
        }
        params.add(start);
        params.add(rows);
        stringBuilder.append(" limit ? , ? ");
        return template.query(stringBuilder.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }

}

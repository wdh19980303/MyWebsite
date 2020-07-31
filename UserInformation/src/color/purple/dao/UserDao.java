package color.purple.dao;

import color.purple.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public int add(User user);

    public int getMaxUsername();

    public int del(int id);

    public User findUserById(int id);

    public int update(User user);

    public int totalCount(Map<String, String[]> condition);

    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}

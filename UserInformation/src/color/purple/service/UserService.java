package color.purple.service;

import color.purple.domain.PageBean;
import color.purple.domain.User;

import java.util.List;
import java.util.Map;

/*
    操作用户事务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 登录方法
     */

    public User login(User user);

    /**
     * 添加用户
     */
    public boolean addUser(User user);

    /**
     * 删除用户
     */

    public boolean delUser(int id);

    /**
     * 根据id找用户
     */
    public User findUserById(int id);

    /**
     * 修改用户信息
     */
    public boolean updateUser(User user);

    /**
     * 删除选中用户
     */
    public boolean delSelectUser(String[] selectIds);

    /**
     * 分页查询条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}

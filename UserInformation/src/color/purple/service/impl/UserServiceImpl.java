package color.purple.service.impl;

import color.purple.dao.UserDao;
import color.purple.dao.impl.UserDaoImpl;
import color.purple.domain.PageBean;
import color.purple.domain.User;
import color.purple.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    // 查询所有用户方法
    @Override
    public List<User> findAll() {
        // 调用 Dao 完成查询
        return dao.findAll();
    }

    // 登录方法
    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    // 添加用户方法
    @Override
    public boolean addUser(User user) {
//        int res = dao.add(user);
        return 1 == dao.add(user);
    }

    // 删除用户方法
    @Override
    public boolean delUser(int id) {
//        return false;
        return 1 == dao.del(id);
    }

    // 根据id找用户
    @Override
    public User findUserById(int id) {
        return dao.findUserById(id);
    }

    // 修改用户信息
    @Override
    public boolean updateUser(User user) {
        return 1 == dao.update(user);
    }

    // 删除选中用户
    @Override
    public boolean delSelectUser(String[] selectIds) {
        int res = 0;
        for (int i = 0; i < selectIds.length; i++) {
            res += dao.del(Integer.parseInt(selectIds[i]));
        }

        return res == selectIds.length;
    }

    // 分页查询
    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0) {
            currentPage = 1;
        }

        // 1 创建空的PageBean
        PageBean<User> pageBean = new PageBean<User>();

        // 2 设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        // 3 获取总记录数
        int totalCount = dao.totalCount( condition );
        pageBean.setTotalCount(totalCount);
        // 4 获取list集合
        // 计算索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pageBean.setList(list);


        // 5 计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) +1;
        pageBean.setTotalPage(totalPage );
        return pageBean;
    }
}

package color.purple.Jedis.test;

import com.sun.tools.attach.AgentInitializationException;
import jdk.jfr.StackTrace;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.lang.model.element.NestingKind;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试
 */
public class JedisTest {
    /**
     * 快速入门
     */

    @Test
    public void test1() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        jedis.set("username", "liya");

        // 3 关闭连接
        jedis.close();
    }

    @Test
    public void test2() {
        // 1 获取连接
        Jedis jedis = new Jedis(); // 使用空参构造,默认值"localhost,6397"
        // 2 操作
        String username = jedis.get("username");
        System.out.println(username);

        // 3 关闭连接
        jedis.close();
    }

    @Test
    public void test3() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        Long username = jedis.del("username");
        System.out.println(username);

        // 3 关闭连接
        jedis.close();
    }

    @Test
    public void test4() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        jedis.setex("activeCode", 20, "i love");
        // 3 关闭连接
        jedis.close();
    }


    /******************************************************************************************************************/
    // hash操作
    @Test
    public void test5() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        jedis.hset("user", "name", "vox");
        jedis.hset("user", "age", "25");

        // 3 关闭连接
        jedis.close();
    }

    @Test
    public void test6() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        String name = jedis.hget("user", "name");
        String age = jedis.hget("user", "age");

        System.out.println(name);
        System.out.println(age);

        // 3 关闭连接
        jedis.close();
    }

    @Test
    public void test7() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            System.out.println("key :" + key + "___" + "value :" + user.get(key));
        }

        // 3 关闭连接
        jedis.close();
    }

    /******************************************************************************************************************/
    // list操作
    @Test
    public void test8() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        Map<String, String> user = jedis.hgetAll("user");
        jedis.lpush("mylist", "a", "b", "c", "d");
        jedis.rpush("mylist", "a", "b", "c", "d");
        // list 范围索取
        List<String> mylist = jedis.lrange("mylist",0,-1);
        System.out.println(mylist);

        // 3 关闭连接
        jedis.close();
    }


    @Test
    public void test9() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        String l = jedis.lpop("mylist");
        System.out.println(l);

        // 3 关闭连接
        jedis.close();
    }

    /******************************************************************************************************************/
    // set操作 不允许出现重复的元素

    @Test
    public void test10() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        // set 存储
        jedis.sadd("myset","java","php","c++");
        // 3 关闭连接
        jedis.close();
    }

    @Test
    public void test11() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作
        // 获取set集合
        Set<String> mySet = jedis.smembers("myset");
        System.out.println(mySet);


        // 3 关闭连接
        jedis.close();
    }

    /******************************************************************************************************************/
    // sortedset
    @Test
    public void test12() {
        // 1 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2 操作

        // 添加
        jedis.zadd("mysortedset",3,"alice");
        jedis.zadd("mysortedset",4,"cat");
        jedis.zadd("mysortedset",12,"momo");

        // set
        Set<String> mysortedset = jedis.zrange("mysortedset",0,-1);
        System.out.println(mysortedset);

        // 3 关闭连接
        jedis.close();
    }
}



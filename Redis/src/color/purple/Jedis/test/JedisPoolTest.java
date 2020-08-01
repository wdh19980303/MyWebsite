package color.purple.Jedis.test;

import color.purple.Jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolTest {
    @Test
    public void test1() {
        // 创建连接池对象

        JedisPool jedisPool = new JedisPool();

        // 获取连接
        Jedis jedisConnection = jedisPool.getResource();

        jedisConnection.set("id","alicecat");

        System.out.println(jedisConnection.get("id"));

        jedisConnection.close();
    }

    @Test
    public void test2() {
        // 通过工具类获取连接
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("love","emt");
    }

    @Test
    public void test3() {
        InputStream is = JedisPoolTest.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            System.out.println(properties.getProperty("maxTotal"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}

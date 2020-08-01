package color.purple.Jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工具类:
 * 加载配置文件,获取参数
 * 提供获取连接的方法
 *
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;
    private static JedisPoolConfig config = null;

    static {
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        // 获取数据,设置到JedisPoolConfig
        config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));


        //初始化JedisPool
        jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
 }

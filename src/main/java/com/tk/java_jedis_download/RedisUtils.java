package com.tk.java_jedis_download;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class RedisUtils {
    private static JedisPool jedisPool = null;
    private static String host = null;
    private static String port = null;
    private static String maxTotal = null;
    private static String maxIdle = null;

    static {
        ResourceBundle redis = ResourceBundle.getBundle("redis");
        host = redis.getString("redis.host");
        port = redis.getString("redis.port");
        maxTotal = redis.getString("redis.maxTotal");
        maxIdle = redis.getString("redis.maxIdle");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));
        jedisPool = new JedisPool(jedisPoolConfig, host, Integer.parseInt(port));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}

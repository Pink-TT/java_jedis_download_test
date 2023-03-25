package com.tk.java_jedis_download;

import redis.clients.jedis.Jedis;

public class Server {
    private String id;
    private int num;

    public Server(String id, int num) {
        this.id = id;
        this.num = num;
    }

    public void server() {
        Jedis jedis = RedisUtils.getJedis();
        try {
            if (jedis.exists(id)) {
                Long val = jedis.incr(id);
                download(id, num - (Long.MAX_VALUE - val));
            } else {
                jedis.setex(id, 50, Long.MAX_VALUE - num + "");
            }
        } catch (Exception e) {
            System.out.println(id + "已达下载上限！");
        } finally {
            jedis.close();
        }
    }

    private void download(String id, long l) {
        System.out.println(id + "正在下载第 " + l + " 次！");
    }
}

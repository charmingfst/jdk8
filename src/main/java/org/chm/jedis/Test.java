package org.chm.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by charming on 2016/12/30.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        System.out.println("server is running " + jedis.ping());
        Jedis jedis_M = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis_M.ping());
        Jedis jedis_S = new Jedis("127.0.0.1", 6380);
        System.out.println("slave:"+jedis_S.ping());
        jedis_S.slaveof("127.0.0.1", 6379);
        jedis_M.set("k6", "v6");
        Thread.sleep(500);
        System.out.println(jedis_S.get("k6"));

    }
}

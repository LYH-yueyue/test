package com.liu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * springboot的单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02ApplicationTests {

    @Test
    public void contextLoads() {

        Jedis jedis = new Jedis("106.15.47.74", 6379);
        System.out.println(jedis.ping());
        System.out.println(jedis);
    }

}

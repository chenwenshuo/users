package com.cws.users;

import com.cws.users.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class UsersApplicationTests {
    @Autowired
    private RedisUtil redisUtil ;

    @Test
    public void redisTest(){
        redisUtil.set("cws1",123);
        System.out.println(redisUtil.get("cws1"));
    }

    @Test
    void contextLoads() {


    }

}

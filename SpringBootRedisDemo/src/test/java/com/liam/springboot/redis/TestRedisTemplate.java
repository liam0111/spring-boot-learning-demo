package com.liam.springboot.redis;

import com.liam.springboot.redis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Liam
 * @Date: 2019/3/7 16:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
        redisTemplate.opsForValue().set("liam", "liamshi");
        Assert.assertEquals("liamshi", redisTemplate.opsForValue().get("liam"));
    }

    @Test
    public void testObj() {
        User user = new User("aa", "aa123456", "aa@qq.com", "aaaaa", "2019");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("liam", user);
        User u = operations.get("liam");
        System.out.println("user: " + u.toString());
    }

    @Test
    public void testExpire() throws InterruptedException {
        User user = new User("expire", "123456", "expire@qq.com", "expire", "2019");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("expire", user, 100, TimeUnit.MILLISECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("expire");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

    @Test
    public void testDelete() {
        redisTemplate.opsForValue().set("deletekey", "liam");
        redisTemplate.delete("deletekey");
        boolean exists = redisTemplate.hasKey("deletekey");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("hash", "you", "you");
        String value = (String) hash.get("hash", "you");
        System.out.println("hash value: " + value);
    }

    @Test
    public void testList() {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list", "aa");
        listOperations.leftPush("list", "bb");
        listOperations.leftPush("list", "cc");
        String value = (String) listOperations.leftPop("list");
        System.out.println("list value: " + value.toString());

        List<String> values = listOperations.range("list", 0, -1);
        for (String v : values) {
            System.out.println("list range: " + v);
        }
    }

    @Test
    public void testSet() {
        String key = "set";
        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add(key, "aa");
        set.add(key, "bb");
        set.add(key, "bb");
        set.add(key, "cc");
        Set<String> values = set.members(key);
        values.forEach(v -> System.out.println("set value: " + v));
    }

    @Test
    public void testSetMore() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key1 = "set1";
        String key2 = "set2";
        set.add(key1, "aa");
        set.add(key1, "bb");
        set.add(key1, "bb");
        set.add(key1, "cc");
        set.add(key2, "aa");
        set.add(key2, "dd");
        Set<String> diffs = set.difference(key1, key2); //key1中不同于key2的值，而不是key1和key2所有不同的值
        diffs.forEach(d -> System.out.println("diffs set value: " + d));
        Set<String> unions = set.union(key1, key2); //并集
        unions.forEach(u -> System.out.println("unions value: " + u));
    }

    @Test
    public void testZset() {
        String key = "zset";
        redisTemplate.delete(key);
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key, "aa", 1);
        zset.add(key, "bb", 6);
        zset.add(key, "cc", 4);
        zset.add(key, "dd", 3);
        Set<String> zsets = zset.range(key, 0, 3); //从0到3个数据
        zsets.forEach(v -> System.out.println("zset value: " + v));
        Set<String> zsetB = zset.rangeByScore(key, 0, 3); //score从0到3的数据
        zsetB.forEach(v -> System.out.println("zsetB value: " + v));
    }
}

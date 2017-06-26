package com.example.demo;

import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
 	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;


	@Test
	public void contextLoads() {

		stringRedisTemplate.opsForValue().set("myKey", "123456");
		System.out.println(stringRedisTemplate.opsForValue().get("myKey"));
	}

	@Test
	public void testObj() throws Exception {

		User user = new User("archerLj", 27, "lj0011977@163.com");
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("myUser", user);
		operations.set("myUser2", user,1, TimeUnit.MINUTES);
		Thread.sleep(60000);

		boolean exists = redisTemplate.hasKey("myUser");
		if (exists) {
			System.out.println("key myUser exists");
		} else {
			System.out.println("key myUser not exists");
		}

		boolean exists2 = redisTemplate.hasKey("myUser2");
		if (exists2) {
			System.out.println("key myUser2 exists");
		} else {
			System.out.println("key myUser2 not exists");
		}
	}
}

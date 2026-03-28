package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {
	
	@Autowired
	private RedisTemplate<String, Object> redis;
	
	@Test
	void testRedis()
	{
		redis.opsForValue().set("email", "pawanyadav96dev@gmail.com");
		Object email =redis.opsForValue().get("email");
	}

}

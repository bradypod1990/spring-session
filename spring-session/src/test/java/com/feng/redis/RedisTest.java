package com.feng.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class RedisTest {

	@Autowired
	private RedisTemplate redisTemplate;
	@SuppressWarnings("unchecked")
	@Test
	public void redisTest() {
		redisTemplate.execute(new RedisCallback() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(new String("ff").getBytes(), new String("zoufeng").getBytes());
				connection.sAdd("zf".getBytes(), "james".getBytes(),"wade".getBytes());
				byte[] name = connection.get("zoufeng".getBytes());
				System.out.println(new String(name));
				return name;
			}
			
		});
	}
	
	@Test
	public void redisTest2() {
		//redisTemplate.opsForValue().set("hello", "hello");
		redisTemplate.opsForSet().add("name", "zoufeng");
	}
}

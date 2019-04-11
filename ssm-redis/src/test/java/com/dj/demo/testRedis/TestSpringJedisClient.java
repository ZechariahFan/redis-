package com.dj.demo.testRedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-redis.xml"})
public class TestSpringJedisClient {
	
	@Autowired
	JedisClient JedisClient;
	
	@Test
	public void testJedisPoolClient()
	{
		
		Boolean name = JedisClient.exists("name");
		System.out.println(name);
	}
}

package com.dj.demo.testJedisCluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dj.demo.testRedis.JedisClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/JedisCluster.xml"})
public class TestJedisCluster {

	@Autowired
	private JedisClient JedisClient;
	
	@Test
	public void test1()
	{
		Boolean exists = JedisClient.exists("name");
		System.out.println(exists);
	}
}

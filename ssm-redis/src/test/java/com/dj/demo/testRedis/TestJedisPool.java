package com.dj.demo.testRedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedisPool {

	public static void main(String[] args) {
		//创建jedis连接池
		JedisPool jedisPool = new JedisPool("192.168.56.200",6379);
		//从连接池中获取jedis对象
		Jedis j=jedisPool.getResource();
		//设置密码
		j.auth("fzqxsdmm");
		j.set("age", "123");
		System.out.println(j.get("age"));
		//操作完关闭jedis对象
		j.close();
		//关闭jedisPool对象
		jedisPool.close();
	}
}

package com.dj.demo.testJedisCluster;

import org.springframework.beans.factory.annotation.Autowired;

import com.dj.demo.testRedis.JedisClient;

import redis.clients.jedis.JedisCluster;

public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;
	
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		
		return jedisCluster.set(key, value);
	}

	public String get(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.get(key);
	}

	public Boolean exists(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.exists(key);
	}

	public Long expire(String key, int seconds) {
		// TODO Auto-generated method stub
		return jedisCluster.expire(key, seconds);
	}

	public Long ttl(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.ttl(key);
	}

	public Long incr(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.incr(key);
	}

	public Long hset(String key, String field, String value) {
		// TODO Auto-generated method stub
		return jedisCluster.hset(key, field, value);
	}

	public String hget(String key, String field) {
		// TODO Auto-generated method stub
		return jedisCluster.hget(key, field);
	}

	public Long hdel(String key, String... field) {
		// TODO Auto-generated method stub
		return jedisCluster.hdel(key, field);
	}

}

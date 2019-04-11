package com.dj.demo.testRedis;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientPool implements JedisClient {

	
	@Autowired
	private JedisPool jedisPool;
	
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		String val = jedis.set(key, value);
		jedis.close();
		return val;
	}

	public String get(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		String val = jedis.get(key);
		jedis.close();
		return val;
	}

	public Boolean exists(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		Boolean res = jedis.exists(key);
		jedis.close();
		return res;
	}

	public Long expire(String key, int seconds) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		Long t = jedis.expire(key, seconds);
		jedis.close();
		return t;
	}

	public Long ttl(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		Long ttl = jedis.ttl(key);
		jedis.close();
		return ttl;
	}

	public Long incr(String key) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		Long incr = jedis.incr(key);
		return incr;
	}

	public Long hset(String key, String field, String value) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		Long hset = jedis.hset(key, field, value);
		return hset;
	}

	public String hget(String key, String field) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		String hget = jedis.hget(key, field);
		return hget;
	}

	public Long hdel(String key, String... field) {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.auth("fzqxsdmm");
		Long hdel = jedis.hdel(key, field);
		return hdel;
	}

}

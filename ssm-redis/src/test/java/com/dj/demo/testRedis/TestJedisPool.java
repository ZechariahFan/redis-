package com.dj.demo.testRedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedisPool {

	public static void main(String[] args) {
		//����jedis���ӳ�
		JedisPool jedisPool = new JedisPool("192.168.56.200",6379);
		//�����ӳ��л�ȡjedis����
		Jedis j=jedisPool.getResource();
		//��������
		j.auth("fzqxsdmm");
		j.set("age", "123");
		System.out.println(j.get("age"));
		//������ر�jedis����
		j.close();
		//�ر�jedisPool����
		jedisPool.close();
	}
}

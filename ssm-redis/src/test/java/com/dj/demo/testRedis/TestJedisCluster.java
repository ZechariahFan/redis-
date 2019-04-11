package com.dj.demo.testRedis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class TestJedisCluster {

	public static void main(String[] args) throws IOException {
		Set<HostAndPort> nodes =new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("192.168.56.200", 7001));
		nodes.add(new HostAndPort("192.168.56.200", 7002));
		nodes.add(new HostAndPort("192.168.56.200", 7003));
		nodes.add(new HostAndPort("192.168.56.200", 7004));
		nodes.add(new HostAndPort("192.168.56.200", 7005));
		nodes.add(new HostAndPort("192.168.56.200", 7006));
		JedisCluster jediscluster =new JedisCluster(nodes);
		jediscluster.set("name", "ÕÅÈý");
		String name = jediscluster.get("name");
		System.out.println(name);
		jediscluster.close();
	}
}

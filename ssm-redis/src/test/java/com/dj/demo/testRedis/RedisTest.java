package com.dj.demo.testRedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

public class RedisTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.56.200", 6379);
		jedis.auth("fzqxsdmm");
		//string 操作
		//设置一个值
		jedis.set("food", "汉堡包");
		//获得一个值
		String skey1 = jedis.get("food");
		System.out.println(skey1);
		//设置多个值
		jedis.mset("city1","安徽","city2","浙江");
		//遍历mget中多个键中的值
		List<String> mget = jedis.mget("city1","city2");
		for (String string : mget) {
			System.out.println(string);
		}
		//获取city1键中值的长度
		Long strlen = jedis.strlen("city1");
		System.out.println(strlen);
		//设置年龄
		jedis.set("age", "12");
		//给年龄加1
		 jedis.incr("age");
		 //给年龄加2
		 jedis.incrBy("age", 2);
		 //给年龄减一
		 jedis.decr("age");
		 //给年龄加2
		 jedis.decrBy("age", 2);
		 //获得年龄
		 String age = jedis.get("age");
		System.out.println(age);
		//字符串拼接
		jedis.append("city2", "杭州");
		String city2 = jedis.get("city2");
		//输出浙江杭州
		System.out.println(city2);
		//age字段将在10秒钟自动过期
		jedis.expire("age", 10);
		//获取截取后的值，中文是2个字节，英文是一个字节,下标从0开始
		String getrange = jedis.getrange("food", 0, 2);
		System.out.println(getrange);
		String getrange2 = jedis.getrange("age", 0, 0);
		System.out.println(getrange2);
		//设置age在1000毫秒后自动过期
		jedis.pexpire("age", 1000);
		
		//hash
		
		//hash存储
		jedis.hset("name", "f1", "张三");
		jedis.hset("name", "f2", "李四");
		jedis.hset("name", "f3", "王五");
		//取数据
		String val = jedis.hget("name", "f1");
		System.out.println(val);
		//取出多个数据
		List<String> hmget = jedis.hmget("name", "f1","f2","f3");
		for (String str : hmget) {
			System.out.println(str);
		}
		//删除指定的field
		jedis.hdel("name", "f1");
		//判断该键中的字段是否存在
		Boolean hexists = jedis.hexists("name", "f1");
		System.out.println(hexists);
		//获取指定name中的字段和值
		Map<String, String> hgetAll = jedis.hgetAll("name");
		for(String st : hgetAll.keySet())
		{
			System.out.println(st+":"+hgetAll.get(st));
		}
		jedis.hset("val", "num", "10");
		//加10
		jedis.hincrBy("val", "num", 10);
		System.out.println(jedis.hget("val", "num"));
		//只能添加浮点数
		jedis.hincrByFloat("val", "num",1.5);
		System.out.println(jedis.hget("val", "num"));
		//根据name查找出对应filed值
		List<String> hvals = jedis.hvals("name");
		for (String ss : hvals) {
			System.out.println(ss);
		}
		Set<String> hkeys = jedis.hkeys("name");
		//根据指定的name获取field
		for (String k : hkeys) {
			System.out.println(k);
		}
		
		Long hlen = jedis.hlen("name");
			System.out.println(hlen);
		//list
		//栈的方式进行存入数据,插入到列表的头部	
//		jedis.lpush("pp", "p1");
//		jedis.lpush("pp", "p2");
		//获取指定范围的数据
		List<String> lrange = jedis.lrange("pp", 0,1);
		for (String range : lrange) {
			System.out.println(range);
		}
		//按队列的方式插入数据，往尾部插入
//		jedis.rpush("nn", "n3");
//		jedis.rpush("nn", "n2");
//		jedis.rpushx("nn", "n6");
		List<String> lrange2 = jedis.lrange("nn", 0, -1);
		for (String r2 : lrange2) {
			System.out.println(r2);
		}
		//根据索引获取指定的name值
		String v = jedis.lindex("pp", 0);
		System.out.println("eee"+v);
		jedis.linsert("pp",LIST_POSITION.BEFORE, "p2", "55");
		//将55插入到pp集合中位于p2元素之前
		List<String> lrange3 = jedis.lrange("pp", 0, -1);
		for (String string : lrange3) {
			System.out.println(string);
		}
		
		Long llen = jedis.llen("pp");
		System.out.println(llen);
		//若count>0，从表头到表尾进行搜索与该值相同的元素，如果相同则删除
		//若count<0，从表尾到表头进行搜索与该值相同的元素，如果相同则删除
		//若count=0，删除值相同的所有元素
		jedis.lrem("pp", 1, "55");
		String lpop = jedis.lpop("pp");
		//移除并返回第一个元素
		System.out.println(lpop);
		jedis.lset("pp", 0, "22");
		//设置指定下标的元素
		String lpop2 = jedis.lpop("pp");
		System.out.println(lpop2);
	}
}

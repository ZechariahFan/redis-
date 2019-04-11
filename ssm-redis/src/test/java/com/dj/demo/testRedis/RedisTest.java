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
		//string ����
		//����һ��ֵ
		jedis.set("food", "������");
		//���һ��ֵ
		String skey1 = jedis.get("food");
		System.out.println(skey1);
		//���ö��ֵ
		jedis.mset("city1","����","city2","�㽭");
		//����mget�ж�����е�ֵ
		List<String> mget = jedis.mget("city1","city2");
		for (String string : mget) {
			System.out.println(string);
		}
		//��ȡcity1����ֵ�ĳ���
		Long strlen = jedis.strlen("city1");
		System.out.println(strlen);
		//��������
		jedis.set("age", "12");
		//�������1
		 jedis.incr("age");
		 //�������2
		 jedis.incrBy("age", 2);
		 //�������һ
		 jedis.decr("age");
		 //�������2
		 jedis.decrBy("age", 2);
		 //�������
		 String age = jedis.get("age");
		System.out.println(age);
		//�ַ���ƴ��
		jedis.append("city2", "����");
		String city2 = jedis.get("city2");
		//����㽭����
		System.out.println(city2);
		//age�ֶν���10�����Զ�����
		jedis.expire("age", 10);
		//��ȡ��ȡ���ֵ��������2���ֽڣ�Ӣ����һ���ֽ�,�±��0��ʼ
		String getrange = jedis.getrange("food", 0, 2);
		System.out.println(getrange);
		String getrange2 = jedis.getrange("age", 0, 0);
		System.out.println(getrange2);
		//����age��1000������Զ�����
		jedis.pexpire("age", 1000);
		
		//hash
		
		//hash�洢
		jedis.hset("name", "f1", "����");
		jedis.hset("name", "f2", "����");
		jedis.hset("name", "f3", "����");
		//ȡ����
		String val = jedis.hget("name", "f1");
		System.out.println(val);
		//ȡ���������
		List<String> hmget = jedis.hmget("name", "f1","f2","f3");
		for (String str : hmget) {
			System.out.println(str);
		}
		//ɾ��ָ����field
		jedis.hdel("name", "f1");
		//�жϸü��е��ֶ��Ƿ����
		Boolean hexists = jedis.hexists("name", "f1");
		System.out.println(hexists);
		//��ȡָ��name�е��ֶκ�ֵ
		Map<String, String> hgetAll = jedis.hgetAll("name");
		for(String st : hgetAll.keySet())
		{
			System.out.println(st+":"+hgetAll.get(st));
		}
		jedis.hset("val", "num", "10");
		//��10
		jedis.hincrBy("val", "num", 10);
		System.out.println(jedis.hget("val", "num"));
		//ֻ����Ӹ�����
		jedis.hincrByFloat("val", "num",1.5);
		System.out.println(jedis.hget("val", "num"));
		//����name���ҳ���Ӧfiledֵ
		List<String> hvals = jedis.hvals("name");
		for (String ss : hvals) {
			System.out.println(ss);
		}
		Set<String> hkeys = jedis.hkeys("name");
		//����ָ����name��ȡfield
		for (String k : hkeys) {
			System.out.println(k);
		}
		
		Long hlen = jedis.hlen("name");
			System.out.println(hlen);
		//list
		//ջ�ķ�ʽ���д�������,���뵽�б��ͷ��	
//		jedis.lpush("pp", "p1");
//		jedis.lpush("pp", "p2");
		//��ȡָ����Χ������
		List<String> lrange = jedis.lrange("pp", 0,1);
		for (String range : lrange) {
			System.out.println(range);
		}
		//�����еķ�ʽ�������ݣ���β������
//		jedis.rpush("nn", "n3");
//		jedis.rpush("nn", "n2");
//		jedis.rpushx("nn", "n6");
		List<String> lrange2 = jedis.lrange("nn", 0, -1);
		for (String r2 : lrange2) {
			System.out.println(r2);
		}
		//����������ȡָ����nameֵ
		String v = jedis.lindex("pp", 0);
		System.out.println("eee"+v);
		jedis.linsert("pp",LIST_POSITION.BEFORE, "p2", "55");
		//��55���뵽pp������λ��p2Ԫ��֮ǰ
		List<String> lrange3 = jedis.lrange("pp", 0, -1);
		for (String string : lrange3) {
			System.out.println(string);
		}
		
		Long llen = jedis.llen("pp");
		System.out.println(llen);
		//��count>0���ӱ�ͷ����β�����������ֵ��ͬ��Ԫ�أ������ͬ��ɾ��
		//��count<0���ӱ�β����ͷ�����������ֵ��ͬ��Ԫ�أ������ͬ��ɾ��
		//��count=0��ɾ��ֵ��ͬ������Ԫ��
		jedis.lrem("pp", 1, "55");
		String lpop = jedis.lpop("pp");
		//�Ƴ������ص�һ��Ԫ��
		System.out.println(lpop);
		jedis.lset("pp", 0, "22");
		//����ָ���±��Ԫ��
		String lpop2 = jedis.lpop("pp");
		System.out.println(lpop2);
	}
}

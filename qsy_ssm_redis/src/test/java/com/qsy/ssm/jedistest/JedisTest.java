package com.qsy.ssm.jedistest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-*.xml")
public class JedisTest {
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@Test
	public void set(){
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		 nodes.add(new HostAndPort("192.168.136.131", 6379));
		 nodes.add(new HostAndPort("192.168.136.131", 6380));
		 nodes.add(new HostAndPort("192.168.136.131", 6381));
		 nodes.add(new HostAndPort("192.168.136.131", 6382));
		 nodes.add(new HostAndPort("192.168.136.131", 6383));
		 nodes.add(new HostAndPort("192.168.136.131", 6384));
		 @SuppressWarnings("resource")
		JedisCluster jCluster = new JedisCluster(nodes);
		 String result = jCluster.set("kebi", "24号球衣");
		 System.out.println(result);
		 String str = jCluster.get("kebi");
		 System.out.println(str);
	}
	
	@Test
	public void set_01(){
		jedisCluster.set("kebi", "good");
		System.out.println(jedisCluster.get("kebi"));
	}
}

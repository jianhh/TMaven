package com.wego.tmaven.controller;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server successfully");
		System.out.println(jedis.ping());
		
		System.out.println(jedis.get("username"));
		
	}
}

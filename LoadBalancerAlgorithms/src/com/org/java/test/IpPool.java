package com.org.java.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IpPool {
	public static Map<String, Integer> ipMap = new ConcurrentHashMap<>();

	static {
		ipMap.put("192.168.1.1", 0);
		ipMap.put("192.168.1.2", 10);
		ipMap.put("192.168.1.3", 2);
		ipMap.put("192.168.1.4", 4);
		ipMap.put("192.168.1.5", 6);
		ipMap.put("192.168.1.6", 5);
		ipMap.put("192.168.1.7", 7);
		ipMap.put("192.168.1.8", 8);
		ipMap.put("192.168.1.9", 11);
		ipMap.put("192.168.1.10",6);
	}
}

package com.org.java.test;

import com.org.interfaces.LoadBalance;

public class LoadBalanceMain {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		loadBalance();
	}

	public static void loadBalance() {
		doGetServer(new RoundRobin());
		doGetServer(new RandomLoadBalance());
		doGetServer(new IpHashLoadBalancer());
		doGetServer(new WeightRoundRobin());
		doGetServer(new WeightedRandom());
		doGetServer(new LeastConnectionAlgorithm());
	}

	public static void doGetServer(LoadBalance loadBalance) {
		doGetServer(loadBalance, 25);
	}

	private static void doGetServer(LoadBalance loadBalance, int queryTimes) {
		//Collections.sort(ruleList,new ArrayCustomizedSorting());
		for (int i = 0; i < queryTimes; i++) {
			String serverId = loadBalance.getServer(String.valueOf(i));
			System.out.println(String.format("[%s] index:%s,%s", loadBalance.getClass().getSimpleName(), i, serverId));
		}
	}
}

package com.org.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.org.interfaces.LoadBalance;

public class LeastConnectionAlgorithm implements LoadBalance{
	List<LoadBalancerInput> inputList = new ArrayList<LoadBalancerInput>();
	Set<String> servers = IpPool.ipMap.keySet();

	
	public LeastConnectionAlgorithm() {
        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()) {
            String serverItem = iterator.next();
            LoadBalancerInput input = new LoadBalancerInput(serverItem,IpPool.ipMap.get(serverItem));
            inputList.add(input);
//            Integer weight = IpPool.ipMap.get(serverItem);
//            if (weight > 0) {
//                for (int i = 0; i < weight; i++) {
//                    serverList.add(serverItem);
//                }
//            }
        }
        Collections.sort(inputList,new ArrayCustomizedSorting());
	}

	@Override
	public String getServer(String clientIp) {
		String client = null;
		synchronized(inputList) {
			client = inputList.get(0).getIp();
			LoadBalancerInput tempObj = inputList.get(0);
			tempObj.setWeight(tempObj.getWeight()+1);
			inputList.remove(0);
			inputList.add(tempObj);
			Collections.sort(inputList,new ArrayCustomizedSorting());
		}
		System.out.println(inputList);
		return client;
	}
	
	public static void main(String[]a) {
		LeastConnectionAlgorithm obj = new LeastConnectionAlgorithm();
		System.out.println("server ip " + obj.getServer(""));
	}

}

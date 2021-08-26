package com.org.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.org.interfaces.LoadBalance;

public class WeightRoundRobin implements LoadBalance {

	private static Integer position = 0;
	
	@Override
	public String getServer(String clientIp) {
		List<LoadBalancerInput> inputList = new ArrayList<LoadBalancerInput>();
		Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();

        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()) {
            String serverItem = iterator.next();
            //System.out.println("serverItem - "+serverItem);
            LoadBalancerInput input = new LoadBalancerInput(serverItem,IpPool.ipMap.get(serverItem));
            inputList.add(input);
            Integer weight = IpPool.ipMap.get(serverItem);
            //System.out.println("weight = "+weight);
            if (weight > 0) {
                for (int i = 0; i < weight; i++) {
                    serverList.add(serverItem);
                    //System.out.println("adding  - index "+i+" serverItem"+serverItem);
                }
            }

        }
        Collections.sort(inputList,new ArrayCustomizedSorting());
        System.out.println(inputList);
        //System.out.println("server list size  serverList - "+serverList.size());
        synchronized (position) {
//            if (position > serverList.size()) {
//                position = 0;
//            }
        	if (position >= inputList.size()) {
        		position = 0;
        	}
        	//String target = serverList.get(position);
            String target = inputList.get(position).getIp();
            position++;
            return target;
        }
	}

}

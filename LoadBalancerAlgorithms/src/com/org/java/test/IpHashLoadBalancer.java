package com.org.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.org.interfaces.LoadBalance;

public class IpHashLoadBalancer implements LoadBalance {

	@Override
	public String getServer(String clientIp) {
		if (clientIp == null) {
            clientIp = "127.0.0.1";
        }
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        String remoteId = clientIp;
        Integer index = remoteId.hashCode() % serverList.size();
        System.out.println("HASH CODE "+remoteId.hashCode() + "INDEX - "+index);
        String target = serverList.get(index);
        return target;
	}

}

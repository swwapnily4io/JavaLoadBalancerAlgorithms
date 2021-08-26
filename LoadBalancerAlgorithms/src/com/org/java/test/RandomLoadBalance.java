package com.org.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.org.interfaces.LoadBalance;

public class RandomLoadBalance implements LoadBalance {

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        int randomIndex = new Random().nextInt(serverList.size());
        String target = serverList.get(randomIndex);

        return target;
    }

}

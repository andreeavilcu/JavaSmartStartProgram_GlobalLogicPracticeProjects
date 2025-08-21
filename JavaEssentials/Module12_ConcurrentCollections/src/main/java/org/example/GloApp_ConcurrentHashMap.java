package org.example;

import java.util.concurrent.ConcurrentHashMap;

public class GloApp_ConcurrentHashMap {
    private ConcurrentHashMap<String, Integer> followerCounts;

    public void addFollower(String username){
        followerCounts.put(username, 0);
    }


}

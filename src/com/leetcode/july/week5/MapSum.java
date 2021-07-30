package com.leetcode.july.week5;

import java.util.HashMap;

public class MapSum
{
    HashMap<String,Integer> data;

    public MapSum() {
        data=new HashMap<>();
    }

    public void insert(String key, int val) {
        data.put(key,val);
    }

    public int sum(String prefix)
    {
        int result=0;
        for (String key :data.keySet()) {
            if(key.startsWith(prefix))
                result+=data.get(key);
        }
        return result;
    }
}

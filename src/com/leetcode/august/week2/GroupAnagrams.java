package com.leetcode.august.week2;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams
{
    public static void main(String args[])
    {
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        System.out.println(Arrays.deepToString(groupAnagrams.groupAnagramsOld(new String[]{"eat","tea","tan","ate","nat","bat"}).toArray()));
    }


    //try 1
    //1. sort it out every word
    public List<List<String>> groupAnagramsOld(String[] strs) {
        Map<String,List<String>> subResult=new HashMap<>();

        for (String word :strs) {
            //sort char wise
            String tempWord=word.chars().
                    sorted().
                    collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).
                    toString();

            if(subResult.containsKey(tempWord))
            {
                subResult.put(tempWord, new ArrayList<String>(subResult.get(tempWord)){{add(word);}});
            }
            else
            {
                subResult.put(tempWord, new ArrayList<String>(){{add(word);}});
            }
        }

        return subResult.values().stream().collect(Collectors.toList());
    }

    public List<List<String>> groupAnagramsNew(String[] strs){

        Map<String,List<String>> subResult=new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String strTemp=String.valueOf(temp);
            if(!subResult.containsKey(strTemp))
                subResult.put(strTemp,new ArrayList<>());
            subResult.get(strTemp).add(strs[i]);
        }

        return new ArrayList<>(subResult.values());
    }
}

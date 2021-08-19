package com.leetcode.august.week3;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString
{
    public static void main(String args[])
    {
        MinimumWindowSubString minimumWindowSubString=new MinimumWindowSubString();
//        System.out.println(minimumWindowSubString.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(minimumWindowSubString.minWindow("aa","aa"));
    }

    //approach
    // acquire
    // match
    // release
    public String minWindow(String s, String t) {

        String result="";

        //count the required char's to match
        Map<String,Integer> tMap=new HashMap<>();

        for (char c :t.toCharArray()) {
            tMap.put(c+"",tMap.getOrDefault(c+"",0)+1);
        }

        int i=-1;
        int j=-1;

        int mct=0;
        int dmct=t.length();

        Map<String,Integer> sMap=new HashMap<>();

        while(true)
        {
            boolean b1=false;
            boolean b2=false;

            //acquire
            while(i<s.length()-1 && mct<dmct)
            {
                i++;
                String c=s.charAt(i)+"";
                sMap.put(c,sMap.getOrDefault(c,0)+1);

                if(sMap.getOrDefault(c,0)<=tMap.getOrDefault(c,0))
                    mct++;

                b1=true;
            }

            //collect and release
            while (j<s.length()-1 && mct==dmct)
            {
                String prevAns=s.substring(j+1,i+1);
                if(result.length()==0 || prevAns.length()<result.length())
                    result=prevAns;

                j++;
                String c=s.charAt(j)+"";
                if(sMap.get(c)==1)
                    sMap.remove(c);
                else
                    sMap.put(c,sMap.get(c)-1);

                if(sMap.getOrDefault(c,0)<tMap.getOrDefault(c,0))
                    mct--;

                b2=true;
            }

            if (b1==false && b2==false)
                break;
        }
        return result;
    }
}

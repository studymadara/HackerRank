package com.leetcode.august.week3;

public class DecodeWays
{
    public static void main(String ar[])
    {
        DecodeWays decodeWays=new DecodeWays();
        System.out.println(decodeWays.numDecodings("226"));
    }

    public int numDecodings(String s) {
        return helperMethod(s,0,new Integer[s.length()]);
    }

    public int helperMethod(String s,int index,Integer[] dp)
    {
        int length=s.length();
        if (index==length) return 1;

        if(s.charAt(index)=='0') return 0;

        if(dp[index]!=null) return dp[index];

        int res=helperMethod(s,index+1,dp);

        if(index<length-1 && (s.charAt(index)=='1' || s.charAt(index)=='2' && s.charAt(index+1)<'7'))
            res+=helperMethod(s,index+2,dp);

        dp[index]=res;
        return dp[index];
    }
}

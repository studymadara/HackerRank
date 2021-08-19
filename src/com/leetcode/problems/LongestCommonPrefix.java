package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix
{
    public static void main(String ar[])
    {
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    //try1
    //1. check every string with index at same time
    //2. if match then add to result
    //3. if not then clear the result
    public String longestCommonPrefix(String[] strs)
    {
        if (strs==null || strs.length==0) return "";

        String result=strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(result)!=0)
                result=result.substring(0,result.length()-1);
        }
        return result;
    }
}

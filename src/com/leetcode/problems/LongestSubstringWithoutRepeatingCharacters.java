package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String args[])
    {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters=new LongestSubstringWithoutRepeatingCharacters();
        System.out.print(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> count=new HashMap<>();
        int result=0;

        int tempResult=0;
        for (char c:s.toCharArray())
        {
            if(count.containsKey(c))
            {
                tempResult=0;
                count.remove(c);
            }
            else
            {
                tempResult++;
                count.put(c,1);
            }
            if(tempResult>result)
                result=tempResult;
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        HashMap<Character,Integer> saveLoc=new HashMap<>();
        int result=0;

        int i=0;
        int j=0;
        for (char c:s.toCharArray()) {

            if(saveLoc.containsKey(c))
            {
                j=Math.max(j,saveLoc.get(c)+1);
            }

            saveLoc.put(c,i);
            result=Math.max(result,i-j+1);  //pwwkew

            i++;
        }

        return result;
    }
}

package com.leetcode.problems;

import java.util.HashMap;

public class RomanToInteger
{
    public static void main(String ar[])
    {
        RomanToInteger romanToInteger=new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }


    private HashMap<String,Integer> numerals=new HashMap<String,Integer>()
            {{
                    put("M",1000);
                    put("CM",900);
                    put("D",500);
                    put("CD",400);
                    put("C",100);
                    put("XC",90);
                    put("L",50);
                    put("XL",40);
                    put("X",10);
                    put("IX",9);
                    put("V",5);
                    put("IV",4);
                    put("I",1);
            }};

    //try 1
    // MCMXCIV
    // 1. try picking 2 letters at 1st
    // 2. if its a match move along with another 2 letters
    // 3. if not then pick one letter and go to step 1
    public int romanToInt(String s)
    {
        int result=0;
        for (int i = 0; i < s.length();) {
            String temp=s.charAt(i++)+"";
            if((i)<s.length() && numerals.get(temp+s.charAt(i)+"")!=null)
            {
                result+=numerals.get(temp+s.charAt(i++)+"");
            }
            else
                result+=numerals.get(temp);
        }
        return result;
    }
}

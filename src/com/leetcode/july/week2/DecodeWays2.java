package com.leetcode.july.week2;

public class DecodeWays2
{

    public static void main(String[] s)
    {
        System.out.println(numDecodings("**"));
    }

    //try 1
    //1. split the number in 2 digits
    //2. once that is done check number more than 26
    //3. if yes then count the numbers and * 1
    //4. if no then count the numbers and *2
    public static int numDecodings(String s)
    {
        int count=0;

        int twoCount=0;
        int oneCount=0;
        String[] encString=s.split("(?<=\\G..)");
        for (String enc :encString)
        {
            if(enc.contains("*"))  //1*,*
            {
                if(enc.length()==2)
                {
                    if (enc.substring(0,enc.length()-1).equals("1"))
                        twoCount=9;
                    else if (enc.substring(0,enc.length()-1).equals("2"))
                    {
                        twoCount=6;
                        oneCount=3;
                    }
                    else
                        oneCount=9;
                }
                else if(enc.equals("*"))
                    oneCount=9;
            }

            Integer encInt=checkInt(enc);

            if(encInt!=null)
            {
                if(encInt<27)
                    twoCount++;
                else if(encInt>26)
                    oneCount++;
            }
        }

        count=(2*twoCount)+(1*oneCount);
        return count;
    }

    public static Integer checkInt(String number)
    {
        try
        {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException ex)
        {
            return null;
        }

    }
}

package com.rohan.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSequence
{
    public static void main(String args[])
    {
        //INPUT :: xyxyxxxxabcdefffff
        //OUTPUT :: abcdef

        //convert into toCharArray()
        //then use map for string and integer saving
        //if char is found in the map then clear the output and put that in another list which has all the outputs
        //if char is not found in the map then append it to output

        String input="xxxyabcdeffffghi";

        char[] inputArray=input.toCharArray();
        Map<Character,Integer> record=new HashMap<>();
        String output="";

        String tempoutput="";

        for (int i=0;i<inputArray.length;i++)
        {
            if(record.containsKey(inputArray[i]))
            {
                if(output.length()<tempoutput.length())
                {
                    output=tempoutput;
                }
                tempoutput="";
            }
            else
            {
                tempoutput=tempoutput+inputArray[i];
                record.put(inputArray[i],1);
            }
        }

        System.out.println(output);

    }
}

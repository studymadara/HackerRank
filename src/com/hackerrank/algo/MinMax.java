package com.hackerrank.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MinMax
{
    //test case
    // input :: 140537896 243908675 670291834 923018467 520718469

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Stream.of(bufferedReader
                .readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    //1. sort the given array
    //2. get one number out of the array [preferred index]
    //2.1 check array size and loop through the array
    //3. now just add the remaining numbers in the array.
    public static void miniMaxSum(List<Integer> arr)
    {
        //1. sort the given array
        List<Long> arrLong=arr
                .stream()
                .mapToLong(Integer::longValue)
                .filter(value -> 1<= value)
                .filter(value -> value<=Math.pow(10,9))
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        String result="";

        for (int i=arrLong.size()-1;i<arrLong.size();)
        {
            long sum=0;
            for (int j=0;j<arrLong.size();j++)
            {
                //2. get one number out of the array [preferred index]
                if(i!=j)
                {
                    //3. now just add the remaining numbers in the array.
                    sum+=arrLong.get(j);
                }
            }

            result+=sum+" ";

            if(i==arrLong.size()-1)
                i=0;
            else
                break;
        }

        System.out.println(result);

    }
}

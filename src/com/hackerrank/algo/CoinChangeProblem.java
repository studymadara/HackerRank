package com.hackerrank.algo;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CoinChangeProblem
{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static long getWays(int n, List<Long> c)
    {
        // Write your code here
        return makeChange(c,n);
    }

    public static long makeChange(List<Long> coins, long money)
    {
        return makeChange(coins,money,0,new HashMap<>());
    }

    public static long makeChange(List<Long> coins, long money, int index,HashMap<String,Long> memo)
    {
        if(money==0)
            return 1;

        if(index>=coins.size())
            return 0;

        String key=money+"-"+index;

        if(memo.containsKey(key))
            return memo.get(key);

        long amountWithCoin=0;
        long ways=0;
        while(amountWithCoin<=money)
        {
            long remaining=money-amountWithCoin;
            ways+=makeChange(coins,remaining,index+1,memo);
            amountWithCoin+=coins.get(index);
        }

        memo.put(key,ways);

        return ways;
    }

}

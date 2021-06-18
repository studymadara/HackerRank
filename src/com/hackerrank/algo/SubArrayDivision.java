package com.hackerrank.algo;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SubArrayDivision
{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    //try 1
    //1. 1st for loop - through all numbers
    //2. 2nd for loop - add m numbers in it
    //3. check the output of 2nd for loop == day
    public static int birthday(List<Integer> s, int d, int m)
    {
        // Write your code here
        int noOfWays=0;

        for (int i = 0; i < s.size(); i++)
        {
            int add=0;
            int innerCount=1;
            for (int j = i; j < s.size() && innerCount <= m; j++,innerCount++)
            {
                add+=s.get(j);
            }
            if (--innerCount==m && add==d)
                noOfWays++;
        }

        return noOfWays;
    }
}

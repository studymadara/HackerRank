package com.hackerrank.algo;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class EqualProblem
{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = equal(arr);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    //approach
    //try 1
    //1. get the array sorted
    //2. get the max number from array
    //3. get the difference between max and min from the array
    //4. the resulting remainder can be used to get number from 1 2 5

    //REFRESHER - https://www.youtube.com/watch?v=dLgV6lGv4CA

    public static int equal(List<Integer> arr)
    {
        // Write your code here
        int[] possibilities=new int[5];

        int minimum= Collections.min(arr).intValue();

        for (int i=0;i<possibilities.length;i++)
        {
            for (int x:arr)
            {
                int difference=x-minimum;
                int steps=difference/5+(difference%5)/2+((difference%5)%2)/1;
                possibilities[i]+=steps;
            }
            minimum--;
        }

        return Arrays.stream(possibilities).min().getAsInt();
    }

}

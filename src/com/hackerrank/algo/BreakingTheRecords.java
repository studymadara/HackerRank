package com.hackerrank.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BreakingTheRecords
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    //try 1
    //1. scores[0] will be max and min and count 0
    //2. for loop will start from scores[1] .. scores[length]
    //3. scores[n]<max or scores[n]>min then change max and min accordingly
    public static List<Integer> breakingRecords(List<Integer> scores)
    {
        // Write your code here
        List<Integer> result=new ArrayList<>();

        int min=scores.get(0);
        int max=scores.get(0);

        int minCount=0;
        int maxCount=0;

        for (int i = 1; i < scores.size(); i++)
        {
            if(scores.get(i) < min)
            {
                min=scores.get(i);
                minCount++;
            }
            else if (scores.get(i) > max)
            {
                max=scores.get(i);
                maxCount++;
            }
        }

        result.add(maxCount);
        result.add(minCount);

        return result;
    }
}

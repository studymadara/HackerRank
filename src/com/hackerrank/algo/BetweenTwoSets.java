package com.hackerrank.algo;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BetweenTwoSets
{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int getTotalX(List<Integer> a, List<Integer> b)
    {
        // Write your code here
        //try 1
        //The elements of the first array are all factors of the integer being considered
        // x % array1 == 0
        //The integer being considered is a factor of all elements of the second array
        // array2 % x == 0
        // since array1[0] >= x <= array2[0] can only be the value of x
        // if x is factorial of all elements in both arrays it is divisible by all numbers

        Collections.sort(a);
        Collections.sort(b);

        int x= a.get(0);
        int count=0;

        while (x<=b.get(0))
        {
            boolean isFact=false;
            for (int i=0;i<a.size();i++)
            {
                if(x%a.get(i)==0)
                    isFact=true;
                else
                {
                    isFact=false;
                    break;
                }

            }

            if (isFact)
            {
                for (int i=0;i<b.size();i++)
                {
                    if(b.get(i)%x==0)
                        isFact=true;
                    else
                    {
                        isFact=false;
                        break;
                    }
                }
            }

            if (isFact)
            {
                count++;
            }
            x++;
        }
        return count;
    }
}

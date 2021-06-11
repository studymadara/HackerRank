package com.hackerrank.algo;

import java.io.*;
import java.util.stream.LongStream;

public class ConstructArray
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int x = Integer.parseInt(firstMultipleInput[2]);

        long answer = countArray(n, k, x);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    //1. n is size of array
    //2. k is the upper value till we can fill in the values
    //3. x is the last position of array

    // make sure the in whole array next position element != current position element

    //approach
    //1. check size of array and minus it by 2 the remaining value will be the number of combination
    //try 1
    //1. get no of combination using nCr
    //1.1 number of items = k
    //1.2 number of items per set = (n-2)
    //1.3 k!/(n-2)!*(k-(n-2))!
    //try 2
    //1. check no of arrays who ends with x
    //2. check no of arrays who doesn't end with x

    //FOR REFRESHER
    //https://www.youtube.com/watch?v=plaTv9dnP9I

    static long MOD=1000000007;

    public static long countArray(int n, int k, int x)
    {
        //constraints handled
        if(3<=n && n>=Math.pow(10,5))
            return 0;
        if(2<=k && k>=Math.pow(10,5))
            return 0;
        if(1<=x && x>=k)
            return 0;

        long a[]=new long[n];
        long b[]=new long[n];

        a[0]= x==1?1:0;
        b[0]= x==1?0:1;

        for (int i=1;i<n;i++)
        {
            a[i]=b[i-1]%MOD;
            //remaining from a[i-1] combinations with k-1
            //remaining from b[i-1] combinations with k-2
            b[i]=(a[i-1]*(k-1)+b[i-1]*(k-2))%MOD;
        }

        return a[n-1];

    }

    public static long getFact(int number)
    {
        return LongStream.rangeClosed(1,number).reduce(1,(long p,long q)->p*q);
    }
}

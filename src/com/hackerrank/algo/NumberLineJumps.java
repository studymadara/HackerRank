package com.hackerrank.algo;

import java.io.*;

public class NumberLineJumps
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1 --position of k1
     *  2. INTEGER v1 --jump of k1
     *  3. INTEGER x2 --position of k2
     *  4. INTEGER v2 --jump of k2
     */

    //approach
    //1. check v2>v1 then NO
    //2. x1+(y*v1) = x2+(y*v2)
    //3. x1-x2=(y*v2)-(y*v1)
    //4. x1-x2=(v2-v1)y
    //5. x1-x2/v2-v1 =y
    //6. better x1-x2%v2-v1 ==0


    public static String kangaroo(int x1, int v1, int x2, int v2)
    {
        // Write your code here
        //constraints
        if(x1>=0 && x1<=10000 && x2>=0 && x2<=10000
        && v1>=1 && v1<=10000 && v2>=1 && v2<=10000
        && v2<v1 && ((x1-x2)%(v2-v1)==0))
            return "YES";
        else
            return "NO";
    }
}

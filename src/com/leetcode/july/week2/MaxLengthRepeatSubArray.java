package com.leetcode.july.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxLengthRepeatSubArray
{

    public static void main(String args[])
    {
//        System.out.println(findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
        System.out.println(findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4}));
        //
        //[]
    }

    //try 1
    //1. use for loop for nums1 over nums2
    //2. if match then save the number with index in another map <string,value>
    //3.
    public static int findLength(int[] A, int[] B)
    {
        if (B.length<A.length)
        {
            List<Integer> temp=Arrays.stream(B).boxed().collect(Collectors.toList());
            temp.add(0);
            B=temp.stream().mapToInt(i->i).toArray();
        }

        int n = A.length;
        int m = B.length;

        // Auxiliary dp[][] array
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = 0;

        // Updating the dp[][] table
        // in Bottom Up approach
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = m - 1; j >= 0; j--)
            {
                // If A[i] is equal to B[i]
                // then dp[j][i] = dp[j + 1][i + 1] + 1
                if (A[i] == B[j])
                    dp[j][i] = dp[j+1][i+1] + 1;

                System.out.print(" "+dp[j][i]);
            }
            System.out.println("");
        }
        int maxm = 0;

        // Find maximum of all the values
        // in dp[][] array to get the
        // maximum length
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // Update the length
                maxm = Math.max(maxm, dp[i][j]);
            }
        }

        // Return the maximum length
        return maxm;
    }
}

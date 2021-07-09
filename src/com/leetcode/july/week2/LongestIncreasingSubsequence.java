package com.leetcode.july.week2;

import java.util.Arrays;

public class LongestIncreasingSubsequence
{
    //try 1
    //1. start comparing with the number itself if length is 1 then return 1
    //2. compare with previous data if greater than check there dp value go whichever is greater
    //3.
    public int lengthOfLIS(int[] nums)
    {
        int[] dp =new int[nums.length];
        dp[0]=1;
        int overAllMax=1;
        for (int i = 1; i < dp.length; i++)
        {
            int max=0;
            for (int j = 0; j < i; j++)
            {
                if(nums[j]<nums[i])
                    if (dp[j]>max)
                        max=dp[j];
            }
            dp[i]=max+1;
            if(dp[i]>overAllMax)
                overAllMax=dp[i];
        }
        return overAllMax;
    }
}

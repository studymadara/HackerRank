package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum
{
    public static void main(String args[])
    {
        ThreeSum threeSum=new ThreeSum();
//        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(threeSum.threeSum(new int[]{0,0,0}));
//        System.out.println(threeSum.threeSum(new int[]{1,-1,-1,0}));
        System.out.println(threeSum.threeSum(new int[]{-2,0,1,1,2}));
    }

    // try 1
    // 1.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);

        int i=0;
        int j=0;
        int k=0;

        while (i<nums.length)
        {
            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
                int temp=nums[i]+nums[j]+nums[k];
                if(temp==0)
                {
                    lists.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]})));
                    j++;
                    k--;

                    while(j< nums.length && nums[j]==nums[j-1]) j++;
                    while(k>0 && nums[k]==nums[k-1]) k--;
                }
                else if(temp>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
            i++;
            while(i< nums.length && nums[i]==nums[i-1]) i++;
        }
        return lists;
    }
}

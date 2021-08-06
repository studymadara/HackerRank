package com.dsa.sort;

import java.util.Arrays;

public class InsertionSort
{
    public static void main(String arhs[])
    {
        System.out.println(
                Arrays.toString(insertionSort(new int[] {5,1,4,2,8})));
    }

    public static int[] insertionSort(int[] nums)
    {
        for (int i = 1; i < nums.length; i++)
        {
            int key=nums[i];
            int start=i-1;

            while (start>=0 && key<nums[start])
            {
                nums[start+1]=nums[start];
                --start;
            }
            nums[start+1]=key;
        }
        return nums;
    }
}


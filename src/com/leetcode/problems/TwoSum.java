package com.leetcode.problems;

import java.util.*;
import java.util.stream.Stream;

public class TwoSum
{
    public static void main(String args[])
    {
        TwoSum twoSum=new TwoSum();
        System.out.print(Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15},9)));
        System.out.print(Arrays.toString(twoSum.twoSum(new int[]{3,2,4},6)));
        System.out.print(Arrays.toString(twoSum.twoSum(new int[]{2,5,5,11},10)));
    }

    public int[] twoSumTry1(int[] nums, int target)
    {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++)
        {
            int start=0;
            int end=nums.length-1;

            while(start<end)
            {
                if (start!=0 && nums[start]==nums[start-1])
                {
                    start++;
                    continue;
                }

                if(nums[start]+nums[end]>target) end--;
                else if (nums[start]+nums[end]<target)start++;
                else
                {
                    result.add(start);
                    result.add(end);
                    end--;
                    start++;

                    while(start<end && nums[start]==nums[start-1]) start++;
                    while(start<end && nums[end]==nums[end+1]) end--;
                }
            }
        }

        return result.stream().mapToInt(t->t).toArray();
    }

    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer> resultSave=new HashMap<>();
        int[] result=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(resultSave.containsKey(target-nums[i]))
            {
                result[0]=i;
                result[1]=resultSave.get(target-nums[i]);
                return result;
            }
            resultSave.put(nums[i],i);
        }
        return result;
    }

}

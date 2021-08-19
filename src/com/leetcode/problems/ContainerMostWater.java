package com.leetcode.problems;

public class ContainerMostWater
{
    public static void main(String args[])
    {
        ContainerMostWater containerMostWater=new ContainerMostWater();
        System.out.println(containerMostWater.maxArea(new int[]{4,3,2,1,4}));
    }

    // try 1
    // 1.
    public int maxArea(int[] height) {
        int maxArea=0;
        int i=0;
        int j=height.length-1;

        while (i<j)
        {
            if(height[i]<height[j])
            {
                maxArea=Math.max(maxArea,height[i]*(j-i));
                i++;
            }
            else
            {
                maxArea=Math.max(maxArea,height[j]*(j-i));
                j--;
            }
        }

        return maxArea;
    }
}

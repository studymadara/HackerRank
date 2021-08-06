package com.leetcode.problems;

import java.util.Arrays;
import java.util.stream.Stream;

public class MedianSortedArrays
{
    public static void main(String args[])
    {
        MedianSortedArrays medianSortedArrays=new MedianSortedArrays();
        System.out.println(medianSortedArrays.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(medianSortedArrays.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(medianSortedArrays.findMedianSortedArrays(new int[]{0,0},new int[]{0,0}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        double finalResult=0;

        int[] result=new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,result,0,nums1.length);
        System.arraycopy(nums2,0,result,nums1.length,nums2.length);

        Arrays.sort(result);

        if(result.length%2==0)
        {
            int middlePos=result.length/2;
            finalResult=(result[middlePos-1]+result[(middlePos)])/2.0;
        }
        else
           finalResult=result[result.length/2];

        return finalResult;
    }
}

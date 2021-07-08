package com.leetcode.july.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestElementSortedMatrix
{
    public static void main(String args[])
    {

    }

    //try 1
    //1. get all the data from array into one sorted list
    //2. return the kth value using .get() #maybe
    public int kthSmallest(int[][] matrix, int k)
    {
        List<Integer> allData=new ArrayList<>();
        for (int[] innerMatrix :matrix)
        {
            for (int x:innerMatrix)
            {
                allData.add(x);
            }
        }

        Collections.sort(allData);

        return allData.get(k-1);
    }
}

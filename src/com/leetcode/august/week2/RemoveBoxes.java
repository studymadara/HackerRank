package com.leetcode.august.week2;

import java.util.HashMap;
import java.util.Map;

public class RemoveBoxes
{
    public static void main(String args[])
    {
        RemoveBoxes removeBoxes=new RemoveBoxes();
//        System.out.println(removeBoxes.removeBoxes(new int[]{1,3,2,2,2,3,4,3,1}));
        System.out.println(removeBoxes.removeBoxes(new int[]{1,2,2,1,1,1,2,1,1,2,1,2,1,1,2,2,1,1,2,2,1,1,1,2,2,2,2,1,2,1,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,1,1,2,2,1,2,1,2,2,1,2,1,1,1,2,2,2,2,2,1,2,2,2,2,2,1,1,1,1,1,2,2,2,2,2,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,2,1}));

    }

    public int removeBoxesOld(int[] boxes) {
        Map<Integer,Integer> countBox=new HashMap<>();
        int result=0;

        for (int box:boxes) {
            if(!countBox.containsKey(box))
                countBox.put(box,0);
            countBox.put(box,countBox.get(box)+1);
        }

        for (Integer uniqueBox :countBox.keySet()) {
            result+=countBox.get(uniqueBox)*countBox.get(uniqueBox);
        }

        return result;
    }

    public int removeBoxes(int[] boxes){
        int size=boxes.length;
        int[][][] dp=new int[size][size][size];
        return helperMethod(boxes,0,size-1,0,dp);
    }

    public int helperMethod(int[] boxes,int i,int j,int k,int[][][] dp)
    {
        if(i>j) return 0;
        if (dp[i][j][k]>0) return dp[i][j][k];

        //start from i to j
        for (;i+1<=j && boxes[i+1]==boxes[i];i++,k++);

        int res=(k+1)*(k+1)+helperMethod(boxes,i+1,j,0,dp);

        //from m to j
        for (int m=i+1;m<=j;m++)
        {
            if(boxes[i]==boxes[m])
            {
                res=Math.max(res,helperMethod(boxes,i+1,m-1,0,dp)+helperMethod(boxes,m,j,k+1,dp));
            }
        }
        dp[i][j][k]=res;
        return res;
    }
}

package com.dsa.search;

public class BinarySearch
{
    public static void main(String args[])
    {
        binarySearch(new int[]{10,12,14,16,19,20,21},14);
    }

    public static void binarySearch(int[] sortedArray,int target)
    {
        int low=sortedArray[0];
        int high=sortedArray[sortedArray.length-1];

        while(low<=high)
        {
            int midpoint=(high-low)/2;
            if(sortedArray[midpoint]==target)
            {
                System.out.println("FOUND :: "+sortedArray[midpoint]+ " TARGET :: "+target);
                break;
            }
            else if(sortedArray[midpoint]> target)
                high--;
            else if(sortedArray[midpoint]<target)
                low++;
        }
    }
}

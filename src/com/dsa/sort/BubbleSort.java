package com.dsa.sort;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String args[])
    {
        System.out.println(
                Arrays.toString(bubbleSort(new int[] {5,1,4,2,8})));
    }

    public static int[] bubbleSort(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i]>array[j]){
                    array[i]+=array[j];
                    array[j]=array[i]-array[j];
                    array[i]=array[i]-array[j];
                }
            }
        }

        return array;
    }
}

package com.leetcode.july.week3;

public class ThreeEqualParts
{
    public static void main(String args[])
    {
        int [] result=threeEqualParts(new int[]{0,1,0,1,1});
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] threeEqualParts(int[] arr)
    {
        //1. check weather no of 1's are not multiple of 3
        //2. if multiple of 3 then lets go ahead
        //3. if not then break it with -1,-1
        //4. now the important part of breaking the code in 3 segments
        //5. get 1 index from part 1
        //6. get 1 index from part 2
        //7. get 1 index from part 3
        //8. part 1 is defined from arr[0]
        //9. part 2 is defined from arr[noOf1's /3 + 1 ]
        //9. part 3 is defined from arr[ 2 * noOf1's /3 + 1 ]

        int[] result=new int[]{-1,-1};
        int checkNoOfOne=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1)
                checkNoOfOne++;
        }

        if(checkNoOfOne==0)
        {
            return new int[]{0,2};
        }

        if(checkNoOfOne%3!=0)
        {
            return result;
        }

        int indexPart1=-1;
        int indexPart2=-1;
        int indexPart3=-1;
        int averageOfOnes=checkNoOfOne/3;

        checkNoOfOne=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1)
            {
                checkNoOfOne++;
                if (checkNoOfOne==1)
                {
                    indexPart1=i;
                }
                else if (checkNoOfOne==averageOfOnes+1)
                {
                    indexPart2=i;
                }
                else if (checkNoOfOne==2*averageOfOnes+1)
                {
                    indexPart3=i;
                }
            }
        }

        while (indexPart3< arr.length)
        {
            if(arr[indexPart1]==arr[indexPart2] && arr[indexPart2]==arr[indexPart3])
            {
                indexPart1++;
                indexPart2++;
                indexPart3++;
            }
            else
                return result;
        }

        return new int[]{indexPart1-1,indexPart2};
    }
}

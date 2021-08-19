package com.leetcode.august.week1;

import java.util.stream.IntStream;

public class PalindromePatitioning2
{
    public static void main(String args[])
    {
        PalindromePatitioning2 palindromePatitioning2=new PalindromePatitioning2();
//        System.out.println(palindromePatitioning2.minCut("aab"));
//        System.out.println(palindromePatitioning2.minCut("a"));
        System.out.println(palindromePatitioning2.minCut("ab"));
//        System.out.println(palindromePatitioning2.minCut("bb"));
        System.out.println(palindromePatitioning2.minCut("efe"));
    }

    //try1
    // generate all the palindrome exists in the string
    // check there starting index and check if main string has --starting index if yes then count++
    // check there ending index and check if main string has ++ending index if yes then count++
    // create temp variable to save the min cut value
    public int minCutOld(String s) {

        int minTempCount=Integer.MAX_VALUE;

        for (int i=0;i<s.length();i++)
        {
            int start=i;
            int end=s.length()-1;

            int calculateCut=0;
            boolean checkPalin=false;
            //good when no of string is greater than 3
            while (start<=end)
            {
                if(isPalindrome(s,start,end))
                {
                    checkPalin=true;
                    int calculatePreIndex=start<=0?0:start-1;
                    int calculatePostIndex=end<s.length()?end+1:end;

                    if(calculatePreIndex!=0 && calculatePostIndex!=s.length())
                        calculateCut+=2;
                    else if((calculatePreIndex!=0 && s.charAt(calculatePreIndex) != s.charAt(start))
                            || (calculatePostIndex!=s.length() && s.charAt(calculatePostIndex) != s.charAt(end)))
                        calculateCut+=1;
                }
                end--;
            }

            if(calculateCut<minTempCount && checkPalin && calculateCut>0) //
                minTempCount=calculateCut;
        }

        return minTempCount==Integer.MAX_VALUE?0:minTempCount;
    }


    public boolean isPalindrome(String data,int start,int end)
    {
        while(start<=end)
        {
            if(data.charAt(start)!=data.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }


    //try2 still using O(n*n)
    public int minCutOld2(String s) {
        return helperMethod(s,0,s.length()-1);
    }

    public int helperMethod(String data,int start,int end)
    {
        if(start==end || isPalindrome(data,start,end))
            return 0;

        int minCut=data.length()-1;

        for (int i = start; i <= end; i++) {
            if(isPalindrome(data,start,i))
            {
                minCut=Math.min(minCut,1+helperMethod(data,i+1,end));
            }
        }

        return minCut;
    }

    //try 3
    //the better approach using DP
    public int minCut(String s) {
        if(s==null || s.length()<=0)
            return 0;

        //dp
        int n=s.length();
        int[] dp= IntStream.range(0,n).toArray();

        //for mid
        for (int i = 1; i < n; i++) {

            //for odd case
            for (int start=i,end=i;start>=0 && end<n && s.charAt(start)==s.charAt(end);start--,end++)
            {
                int newCutEnd=start==0?0:dp[start-1]+1;
                dp[end]=Math.min(dp[end],newCutEnd);
            }

            //for even case
            for (int start=i-1,end=i;start>=0 && end<n && s.charAt(start)==s.charAt(end);start--,end++)
            {
                int newCutEnd=start==0?0:dp[start-1]+1;
                dp[end]=Math.min(dp[end],newCutEnd);
            }
        }

        return dp[n-1];
    }
}

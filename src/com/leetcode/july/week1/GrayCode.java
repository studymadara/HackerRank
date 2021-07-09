package com.leetcode.july.week1;

import java.util.ArrayList;
import java.util.List;

public class GrayCode
{
    public List<Integer> grayCode(int n)
    {
        List<Integer> data=new ArrayList<>();
        for (int i = 0; i < (Math.pow(2,n)-1); i++) {
            data.add(i);
        }
        return data;
    }
}

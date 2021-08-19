package com.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerToRoman
{
    public static void main(String args[])
    {
        IntegerToRoman integerToRoman=new IntegerToRoman();

        System.out.println(integerToRoman.intToRoman(58));

    }

    //try 1
    // 1. get all the numbers out of the given number
    // 2. like 1995->1000+900+90+5
    // 3. then convert using map and save it in result variable

    public String intToRomanOld(int num) {
        String resultStr="";
        List<Integer> numsList=new ArrayList<>();

        getNumbers(num,numsList);

        System.out.println(Arrays.toString(numsList.toArray()));

        return resultStr;

    }

    //get numbers in list format
    public void getNumbers(int num,List<Integer> numsList)
    {
        if(num==0)
            return;
        int numSize=(int)Math.log10(num)+1;
        int divisionNumber=1;
        while(numSize-->1)divisionNumber=divisionNumber*10;
        numsList.add((num/divisionNumber)*divisionNumber);

        getNumbers(num%divisionNumber,numsList);
    }

    //get numbers to roman numbers
//    public String getRomanNum(int num)
//    {
//        if(num==0)
//        {
//            return "";
//        }
//
//        Map<Integer,String> romanNoData=new TreeMap<>();
//        romanNoData.put(1,"I");
//        romanNoData.put(5,"V");
//        romanNoData.put(10,"X");
//        romanNoData.put(50,"L");
//        romanNoData.put(100,"C");
//        romanNoData.put(500,"D");
//        romanNoData.put(1000,"M");
//
//        if(romanNoData.containsKey(num))
//            return romanNoData.get(num);
////        else if(num>romanNoData.)
//    }



    ///// try 2
    //1. same thing but save roman data in custom class
    class Numeral{
        public String symbol;
        public int value;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Numeral(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }

    private Numeral[] numerals=new Numeral[]
            {
                    new Numeral("M",1000)
                    ,new Numeral("CM",900)
                    ,new Numeral("D",500)
                    ,new Numeral("CD",400)
                    ,new Numeral("C",100)
                    ,new Numeral("XC",90)
                    ,new Numeral("L",50)
                    ,new Numeral("XL",40)
                    ,new Numeral("X",10)
                    ,new Numeral("IX",9)
                    ,new Numeral("V",5)
                    ,new Numeral("IV",4)
                    ,new Numeral("I",1)
            };

    public String intToRoman(int num) {
        String resultStr="";

        for (Numeral n:numerals) {
            int numOfSymbols=num/n.value;
            if(numOfSymbols!=0)
            {
                resultStr+=Collections.nCopies(numOfSymbols,n.symbol)
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
            }
            num%=n.value;
        }

        return resultStr;

    }
}

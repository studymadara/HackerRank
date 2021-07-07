package com.hackerrank.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DNAHealth
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        List<StrandSample> strandSampleList=new ArrayList<>();

        IntStream.range(0, s).forEach(sItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine()
                        .replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];

                StrandSample strandSample=new StrandSample();
                strandSample.setFirst(first);
                strandSample.setLast(last);
                strandSample.setStrandData(d);

                strandSampleList.add(strandSample);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        calculateResult(genes,health,strandSampleList);

        bufferedReader.close();
    }

    public static class StrandSample
    {
        int first;
        int last;
        String strandData;
        int strandDataHealthCount;

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getLast() {
            return last;
        }

        public void setLast(int last) {
            this.last = last;
        }

        public String getStrandData() {
            return strandData;
        }

        public void setStrandData(String strandData) {
            this.strandData = strandData;
        }

        public int getStrandDataHealthCount() {
            return strandDataHealthCount;
        }

        public void setStrandDataHealthCount(int strandDataHealthCount) {
            this.strandDataHealthCount = strandDataHealthCount;
        }
    }


    public static void calculateResult(List<String> genes,List<Integer> health,List<StrandSample> strandSampleList)
    {
        //1. go through the strand like 'axb'
        //2. a,ax,axb,x,xb,b
        //3. now since the data is made now compare this with gene data
        //4. if multiple times found add both of the times
        //5. probably this will be the answer for the respective strand


        //approach 2
        //1. start with genes loop [start,end]
        //2. check gene length accordingly create the strand samples
        //3. add health if gene == stand sample

        for (StrandSample strandSample:strandSampleList)
        {
            int sumOfSampleStrandData=0;
            //gene loop
            for (int i = strandSample.getFirst(); i < strandSample.getLast(); i++)
            {
                //1.get length of the gene
                int geneLength=genes.get(i).length();
                //2. now will move pointer
                for (int j = 0; j < strandSample.getStrandData().length(); j++)
                {
                    if(j>j+geneLength)
                        break;

                    String sampleStrandData=strandSample.getStrandData().substring(j,j+geneLength);

                    System.out.println(sampleStrandData +" :: "+ genes.get(i));
                    if (genes.get(i).equals(sampleStrandData))
                    {
                        sumOfSampleStrandData+=health.get(i);
                    }

                }
            }
            strandSample.setStrandDataHealthCount(sumOfSampleStrandData);

            System.out.println(strandSample.getStrandData()+" :: "+strandSample.getStrandDataHealthCount());
        }


    }
}

package com.leetcode.august.week2;

import java.util.Arrays;

public class SetMatrixZeroes
{
    public static void main(String args[])
    {
        SetMatrixZeroes setMatrixZeroes=new SetMatrixZeroes();
//        int[][] question=new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] question=new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        setMatrixZeroes.setZeroes(question);
    }

    int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    //try 1
    // 1. traverse through the matrix and check for only 0
    // 2. once 0 is found then just do check all the sides and repeat only 1 direction
    
    public void setZeroes(int[][] matrix) {
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0 && !visited[i][j])
                {
                    for (int[] direction :directions) {
                        visitOneDirection(matrix,i,j,direction[0],direction[1],visited);
                    }
                }
            }
        }

//        System.out.println(Arrays.deepToString(matrix));
    }


    public void visitOneDirection(int[][] matrix,int i,int j,int directionX,int directionY,boolean[][] visited)
    {
        //check if not outside of the array
        int newCurrX=i+directionX;
        int newCurrY=j+directionY;
        if(newCurrX>-1 && newCurrX<matrix.length &&  newCurrY>-1 && newCurrY<matrix[i].length)
        {
            if(matrix[newCurrX][newCurrY]!=0)
            {
//                System.out.println("NEW VALUE : "+matrix[newCurrX][newCurrY]);
                matrix[newCurrX][newCurrY]=0;
//                System.out.println(Arrays.deepToString(matrix));
                visited[newCurrX][newCurrY]=true;
//                System.out.println(Arrays.deepToString(visited));
            }
            visitOneDirection(matrix,newCurrX,newCurrY,directionX,directionY,visited);
        }
    }
}

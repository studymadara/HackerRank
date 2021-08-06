package com.dsa.search;

import jdk.nashorn.internal.ir.Node;

public class BreadthFirstSearch
{
    public static class Node
    {
        int value;
        Node left;
        Node right;
        Node(int value)
        {
            this.value=value;
        }
        Node(int value,Node left,Node right)
        {
            this.value=value;
            this.left=left;
            this.right=right;
        }

    }


    public static void main(String args[])
    {
        breadthSearch(new Node
                (5,
                new Node(6,
                        new Node(3,new Node(1),new Node(2)),
                        new Node(8,new Node(9),new Node(1))
                        ),
                new Node(10,
                        new Node(11,new Node(15),new Node(20)),
                        new Node(12,new Node(18),new Node(22))
                        )
                ),22);
    }

    public static void breadthSearch(Node rootNode,int target)
    {
        if(rootNode==null)
            return ;

        if(target==rootNode.value)
            System.out.println("FOUND :: "+rootNode.value+ " TARGET :: "+target);

        breadthSearch(rootNode.left,target);
        breadthSearch(rootNode.right,target);
    }
}

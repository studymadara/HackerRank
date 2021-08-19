package com.dsa.search;

public class DepthFirstSearch
{
    public static class Node
    {
        int value;
        DepthFirstSearch.Node left;
        DepthFirstSearch.Node right;
        Node(int value)
        {
            this.value=value;
        }
        Node(int value, DepthFirstSearch.Node left, DepthFirstSearch.Node right)
        {
            this.value=value;
            this.left=left;
            this.right=right;
        }

    }


    public static void main(String args[])
    {
        breadthSearch(new DepthFirstSearch.Node
                (5,
                        new DepthFirstSearch.Node(6,
                                new DepthFirstSearch.Node(3,new DepthFirstSearch.Node(1),new DepthFirstSearch.Node(2)),
                                new DepthFirstSearch.Node(8,new DepthFirstSearch.Node(9),new DepthFirstSearch.Node(1))
                        ),
                        new DepthFirstSearch.Node(10,
                                new DepthFirstSearch.Node(11,new DepthFirstSearch.Node(15),new DepthFirstSearch.Node(20)),
                                new DepthFirstSearch.Node(12,new DepthFirstSearch.Node(18),new DepthFirstSearch.Node(22))
                        )
                ),22);
    }
    
    public static void breadthSearch(DepthFirstSearch.Node rootNode, int target)
    {
        if(rootNode==null)
            return ;

        if(target==rootNode.value)
            System.out.println("FOUND :: "+rootNode.value+ " TARGET :: "+target);

        breadthSearch(rootNode.left,target);
        breadthSearch(rootNode.right,target);
    }
}

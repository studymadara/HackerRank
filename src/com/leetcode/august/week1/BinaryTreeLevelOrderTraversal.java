package com.leetcode.august.week1;

import com.dsa.search.BinarySearch;

import java.util.*;

public class BinaryTreeLevelOrderTraversal
{
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String ss[])
    {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal=new BinaryTreeLevelOrderTraversal();
        System.out.println(Arrays.toString(binaryTreeLevelOrderTraversal.levelOrder
                (
                        new Node(1,new ArrayList<Node>()
                        {{
                            add(new Node(3,new ArrayList<Node>()
                            {{
                                add(new Node(5,null));
                                add(new Node(6,null));
                            }}));
                            add(new Node(2,null));
                            add(new Node(4,null));
                        }})
                ).toArray()));
    }

    public List<List<Integer>> levelOrderOld(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        helperMethod(root,result,new ArrayList<>());
        Collections.reverse(result);
        result.add(0,new ArrayList<Integer>(){{add(root.val);}});
        return result;
    }

    public void helperMethod(Node root,List<List<Integer>> result,List<Integer> sub)
    {
        if (root.children==null)
        {
            return;
        }

        List<Integer> level=new ArrayList<>();

        for (Node child:root.children) {
            helperMethod(child,result,level);
            sub.add(child.val);
        }

        if (!sub.isEmpty())
            result.add(sub);
    }

    public List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> resLists=new ArrayList<>();
        List<Integer> levels=null;

        //using queue
        Queue<Node> queue=new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size=queue.size();
            levels=new ArrayList<>();
            while (size-->0)
            {
                Node cRoot=queue.poll();
                levels.add(cRoot.val);
                if(cRoot.children!=null)
                {
                    for (Node ccRoot :cRoot.children) {
                        queue.offer(ccRoot);
                    }
                }
            }

            resLists.add(levels);
        }

        return  resLists;
    }



}

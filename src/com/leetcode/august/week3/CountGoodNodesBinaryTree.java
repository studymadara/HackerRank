package com.leetcode.august.week3;

public class CountGoodNodesBinaryTree
{
    public static void main(String args[])
    {
        CountGoodNodesBinaryTree countGoodNodesBinaryTree=new CountGoodNodesBinaryTree();
        System.out.println(countGoodNodesBinaryTree.goodNodes(new TreeNode(
                3,
                new TreeNode(1,
                        new TreeNode(3,null,null),
                        null),
                new TreeNode(4,

                        new TreeNode(1,null,null),
                        new TreeNode(5,null,null))
                )));
    }

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

    //try1
    //1. start with root get its value now traverse to all the nodes
    //2. if any value is less than the root or the previous node value then break that loop
    //3. and traverse the rest of the tree.

    public int goodNodes(TreeNode root) {
        return helperMethod(root)+1;
    }

    public int helperMethod(TreeNode node)
    {
        if(node==null)
            return 0;

        int count=0;
        if(node.left!=null && node.left.val>=node.val)
            count+=1;
        else if(node.left!=null)
            node.left.val=node.val;

        if(node.right!=null && node.right.val>=node.val)
            count+=1;
        else if(node.right!=null)
            node.right.val=node.val;

        return count+helperMethod(node.left)+helperMethod(node.right);
    }

}

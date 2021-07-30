package com.leetcode.problems;

import java.util.List;

public class AddTwoNumbers
{
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;

        ListNode result=new ListNode(0);

        ListNode p=new ListNode(0);

        result=p;

        while(l1!=null || l2!=null || carry!=0)
        {
            if(l1!=null)
            {
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                carry+=l2.val;
                l2=l2.next;
            }

            result.next=new ListNode(carry%10);
            carry/=10;
            result=result.next;
        }
        return p.next;
    }

    public String getNumber(ListNode e)
    {
        String result="";
        while(e!=null)
        {
            result+=e.val;
            e=e.next;
        }
        return result;
    }

    public ListNode genNode(String ans)
    {
        ListNode result=new ListNode();
        char[] strChar=ans.toCharArray();
        result.val=strChar[0];
        for (int i=1;i<strChar.length;i++)
        {
            result.next=new ListNode(strChar[i]);
        }
        return result;
    }

    public static void main(String args[])
    {
        AddTwoNumbers addTwoNumbers=new AddTwoNumbers();
        System.out.print(addTwoNumbers.getNumber(new AddTwoNumbers.ListNode(2,new AddTwoNumbers.ListNode(4,new ListNode(3)))));
    }
}

package leetcode.addtwonumbers2;

public class Solution {
    ListNode head;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        mergeNode(l1, l2, 0, null);
        return head;
    }

    void mergeNode(ListNode l1, ListNode l2, int preCount, ListNode pre) {
        if(l1 == null) {
            connectNode(l2, preCount, pre);
            return ;
        }
        else if(l2 == null) {
            connectNode(l1, preCount, pre);
            return ;
        }
        int tmpCount = l1.val + l2.val + preCount;
       // System.out.print
        ListNode newNode = new ListNode(tmpCount % 10, null);
        if(pre != null) pre.next = newNode;
        else head = newNode;
        pre = newNode;
        preCount = tmpCount / 10;
        mergeNode(l1.next, l2.next, preCount, pre);
    }
    void connectNode(ListNode l, int preCount, ListNode pre) {
        if(preCount == 0) {
            pre.next = l;
            return ;
        }
        if(l == null) {
            ListNode newNode = new ListNode(preCount, null);
            pre.next = newNode;
            return ;
        }
        pre.next = l;
        l.val += preCount;
        preCount = l.val / 10;
        l.val %= 10;        
        connectNode(l.next, preCount, l);
    }
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     ListNode head = null, tail = null;
    //     int carry = 0;
    //     while (l1 != null || l2 != null) {
    //         int n1 = l1 != null ? l1.val : 0;
    //         int n2 = l2 != null ? l2.val : 0;
    //         int sum = n1 + n2 + carry;
    //         if (head == null) {
    //             head = tail = new ListNode(sum % 10);
    //         } else {
    //             tail.next = new ListNode(sum % 10);
    //             tail = tail.next;
    //         }
    //         carry = sum / 10;
    //         if (l1 != null) {
    //             l1 = l1.next;
    //         }
    //         if (l2 != null) {
    //             l2 = l2.next;
    //         }
    //     }
    //     if (carry > 0) {
    //         tail.next = new ListNode(carry);
    //     }
    //     return head;
    // }


    

}

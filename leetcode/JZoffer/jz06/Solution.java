package jz06;

class Solution {
    int[] a;
    public int[] reversePrint(ListNode head) {
        // 给一个head
        reverse(head, 1);
        return a;
    }

    void reverse(ListNode node, int i) {
        if(node == null) return ;
        if(node.next != null) {
            reverse(node.next, i+1);
        } else a = new int[i];
        a[a.length - i] = node.val;
    }
}
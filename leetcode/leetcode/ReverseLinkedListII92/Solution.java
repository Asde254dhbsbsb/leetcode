package leetcode.ReverseLinkedListII92;

public class Solution {
    ListNode rNode;// zuo
    ListNode lNode;// you
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        ListNode node = dfs(head, left, right, 1);
        return left == 1 ? node : head;
    }

    public ListNode dfs(ListNode tmp, int left, int right, int n) {
        if(n == left - 1) rNode = tmp;
        if(n == right) {
            lNode = tmp.next;
            if(rNode != null) rNode.next = tmp;
            return tmp;
        }
        ListNode node = dfs(tmp.next, left, right, n+1);
        if(n >= left && n <= right) {
            tmp.next.next = tmp;
            tmp.next = n == left ? lNode : null;
        }
        return node;
    }
}

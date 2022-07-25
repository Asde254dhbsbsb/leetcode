package RemoveNthNodeFromEndofList19;


public class Solution {
    // 删除链表的倒数第 n 个结点，并且返回链表的头结点。
    int tmpCount = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {// 如果head就是倒数第n个节点怎么办
        if(head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        tmpCount++;
        if(tmpCount == n) {
            //  去掉当前节点
            return head.next;
        }
        return head;
    }


}

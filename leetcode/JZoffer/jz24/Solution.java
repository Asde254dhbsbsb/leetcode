    // class Solution {
    //     public ListNode reverseList(ListNode head) {
    //         if(head == null || head.next == null) {
    //             return head;
    //         }
    //         ListNode node = reverseList(head.next);
    //         head.next.next = head;
    //         head.next = null;
    //         return node;
    //     }
    // }
    // 反转列表

package JZoffer.jz24;
public class Solution {
    ListNode head1;
    public ListNode reverseList(ListNode head) {
        //递归逐步解放?
        if(head == null) return null;
        dfs(head);
        return head1;
    }

    public ListNode dfs(ListNode tmp){
        if(tmp.next == null) {
            head1 = new ListNode(tmp.val);
            return head1;
        }
        ListNode node = new ListNode(tmp.val);
        dfs(tmp.next).next = node;
        return node;
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = sl.reverseList(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

package JZoffer.jz36;

// import java.util.ArrayList;
// 利用全局变量存储head和pre

public class Solution {
    // ArrayList<Node> nodeList = new ArrayList<>();
    // Node head, pre;

    // public Node treeToDoublyList(Node root) {
    //     dfs(root);
    //     Node head = null;
    //     int index = 0;
    //     while(index < nodeList.size()) {
    //         Node tmp = nodeList.get(index);
    //         tmp.left = nodeList.get((index - 1 + nodeList.size()) % nodeList.size());
    //         tmp.right = nodeList.get((index + 1) % nodeList.size());
    //         if(index == 0) head = tmp;
    //         index++;



    //     }
    //     return head;
    // }


    // public void dfs(Node root) {
    //     if(root.left == null && root.right == null) {
    //         nodeList.add(root);
    //         return ;
    //     }
    //     if(root.left != null)  dfs(root.left);
    //     nodeList.add(root);
    //     if(root.right != null) dfs(root.right);
    //     return ;
    // }
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        dfs1(root);
        head.left = pre;
        pre.right = head;
        Node tmp = head;

        return head;
    }
    public void dfs1(Node root) {

        if(root == null) return ;
        if(root.left == null && root.right == null) {
            if(pre != null) {
                pre.right = root;
                root.left = pre;
            }
            pre = root;
            return ;
        }
        dfs1(root.left);
        if(pre != null) {
            pre.right = root;
            root.left = pre;
        }
        if(head == null) head = pre == null ? root : pre;

        pre = root;
        dfs1(root.right);   
    }

}

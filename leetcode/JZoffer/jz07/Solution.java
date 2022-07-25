package jz07;
import java.util.Arrays;

// 使用hashMap存储根节点位置，不用for循环
// 使用下标而不是复制！
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        while(inorder[i] != preorder[0]) i++; // 使用hashMap存储根节点位置，不用for循环
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), 
            Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), 
            Arrays.copyOfRange(inorder, i + 1, inorder.length));
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int le, int re) {
        if(preorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        return root;
    }
}

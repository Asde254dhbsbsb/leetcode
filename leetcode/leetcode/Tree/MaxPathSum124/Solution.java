package MaxPathSum124;
public class Solution {
    // 过根节点  不过根节点
    // public int maxPathSum(TreeNode root) {
    //     // root为null怎么办？
    //     if(root == null) {
    //         // root为null 可以假设为无穷小？千万不能return 0不然全是负数不好办！！！
    //         return Integer.MIN_VALUE;
    //     }

    //     int rightMaxLen =  maxPathSum(root.right);
    //     int leftMaxLen =  maxPathSum(root.left);
    //     // 一个为null  两个都为null
    //     int rightLen = dfsGetLenRoot(root.right, root.val, root.val) ;
    //     int leftLen = dfsGetLenRoot(root.left, root.val, root.val);
    //     // 过根节点的最大值
    //     int rootLeftRight = Math.max(rightLen + leftLen - root.val, Math.max(rightLen, leftLen));
    //     return Math.max(rootLeftRight, Math.max(rightMaxLen, leftMaxLen));
    // }

    // int dfsGetLenRoot(TreeNode node, int maxLen, int tmpLen) {
    //     if(node == null) return maxLen;
    //     tmpLen += node.val;
    //     maxLen = Math.max(maxLen, tmpLen);
    //     int leftLen = dfsGetLenRoot(node.left, maxLen, tmpLen);
    //     int rightLen = dfsGetLenRoot(node.right, maxLen, tmpLen);
    //     return Math.max(leftLen, rightLen);
    // }

    // 依次更新！！！！
    private Integer maxLen = Integer.MIN_VALUE;
    public int maxPathSum1(TreeNode root) {
        maxGain(root);
        return maxLen;
    }
    // 递归的计算最大Sum ！！！
    int maxGain(TreeNode node) { // 返回该节点能够给父节点的最大贡献值
        if(node == null) return 0;
        
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        // 对于每个节点计算了能提供的最大贡献值！！！
        // node可以提供的最大和
        int totalTmpSum = leftGain + rightGain + node.val;
        maxLen = Math.max(maxLen, totalTmpSum);

        return Math.max(leftGain + node.val, rightGain + node.val);
    }
}
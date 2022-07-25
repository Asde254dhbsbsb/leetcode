import java.util.ArrayList;
import java.util.List;

class Solution {
    // 思路dp[n] = 1到n做根节点时候的求和
    // 当i做根节点时候
    // 左子树有i-1个节点排列数为dp[i-1]
    // 右子树有n-i个节点，排列数为dp[n-i]
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1]; //以j为根节点，左：dp[j - 1] 右：dp[i - j];
            }
        }
        return dp[n];
    }

    public TreeNode addVal(TreeNode treeNode, int index) {
        if(treeNode == null) return null;
        return new TreeNode(treeNode.val+index, addVal(treeNode.left, index),addVal(treeNode.right, index));
    }

    public List<TreeNode> addIndex(List<TreeNode> list, int index) {
        List<TreeNode> newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            TreeNode newNode = addVal(list.get(i), index);
            newList.add(newNode);
        }
        return newList;
    }

    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        List<TreeNode> tmpList = new ArrayList<>();
        tmpList.add(new TreeNode(1, null, null));
        list.add(tmpList);
        // 对于第n个树
        // 根节点循环为1到n
        // 索引为index时 左边，为1到index-1 右边为root + 1到 n
        // 故左子树直接设为第index-1个列表的所有树
        // 右子树直接设为第n-index个列表的所有树，并且每个节点都+index

        for(int i = 2; i <= n; i++) {
            List<TreeNode> newList = new ArrayList<>();
            for(int root = 1; root <= i; root++) {
                // 左边 
                List<TreeNode> leftList = list.get(root - 1);
                // 右边
                List<TreeNode> rightList = addIndex(list.get(i-root), root);
                
                if(leftList.size() == 0) {
                    for(int r = 0; r < rightList.size(); r++) {
                        TreeNode rightTreeNode = rightList.get(r);
                        newList.add(new TreeNode(root, null, rightTreeNode));
                    }
                }

                if(rightList.size() == 0) {
                    for(int l = 0; l < leftList.size(); l++) {
                        TreeNode leftTreeNode = leftList.get(l);
                        newList.add(new TreeNode(root, leftTreeNode, null));
                    }
                }
                
                for(int l = 0; l < leftList.size(); l++) {
                    for(int r = 0; r < rightList.size(); r++) {
                        TreeNode leftTreeNode = leftList.size() == 0 ? null :leftList.get(l);
                        TreeNode rightTreeNode = rightList.get(r);
                        newList.add(new TreeNode(root, leftTreeNode, rightTreeNode));
                    }
                }

            }
            list.add(newList);
        }
        return list.get(n);
    }
    
}

/**
 * 功能描述
 * LeetCodeHOT100：101.对称二叉树
 * 解法：递归
 */
class Solution {

    public boolean dfs(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        else if(node1 == null || node2 == null)
            return false;
        if(node1.val != node2.val)
            return false;
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }

    public boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }
}
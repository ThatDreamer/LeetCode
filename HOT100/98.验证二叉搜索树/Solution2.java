/**
 * 功能描述
 * LeetCodeHOT100：98.验证二叉搜索树
 * 解法：中序遍历
 */
class Solution {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        if(!isValidBST(root.left)) return false;
        if(root.val <= pre) return false;
        pre = root.val;
        if(!isValidBST(root.right)) return false;
        return true;
    }
}
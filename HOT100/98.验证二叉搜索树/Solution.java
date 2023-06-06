/**
 * 功能描述
 * LeetCodeHOT100：98.验证二叉搜索树
 * 解法：递归
 */
class Solution {

    public boolean isValidBST(TreeNode root, long lower, long upper){
        if(root == null) return true;
        if(root.val <= lower || root.val >= upper)
            return false;
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
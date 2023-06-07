/**
 * 功能描述
 * LeetCodeHOT100：101.对称二叉树
 * 解法：迭代
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        while(!q1.isEmpty()&&!q2.isEmpty()){
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1==null && node2==null) continue;
            else if(node1 == null || node2 == null)
                return false;
            if(node1.val != node2.val)
                return false;
            q1.offer(node1.left);
            q1.offer(node1.right);
            q2.offer(node2.right);
            q2.offer(node2.left);
        }
        return true;
    }
}
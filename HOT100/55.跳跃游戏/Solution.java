/**
 * 功能描述
 * LeetCodeHOT100：55.跳跃游戏
 * 解法：模拟，遍历不断更新能跳的最远距离，时间复杂度为O(n)
 */
class Solution {
    public boolean canJump(int[] nums) {
        int s = 0;
        int t = 1;
        while(s<t && s!=nums.length){
            // System.out.println(s+" "+t);
            t = Math.max(t, nums[s]+s+1);
            s += 1;
        }
        if(s==nums.length)
            return true;
        return false;
    }
}
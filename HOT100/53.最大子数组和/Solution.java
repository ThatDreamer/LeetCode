class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = nums[i];
            if(dp[i-1]+nums[i] > dp[i]){
                dp[i] = dp[i-1]+nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
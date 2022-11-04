/**
 * 功能描述
 * LeetCodeHOT100：31.下一个排列
 * 解法：贪心，时间复杂度为O(n^2)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(nums[j]>nums[i]){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    Arrays.sort(nums, i+1, n);
                    return ;
                }
            }
        }
        Arrays.sort(nums);
    }

}
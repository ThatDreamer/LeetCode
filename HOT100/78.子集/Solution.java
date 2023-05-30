/**
 * 功能描述
 * LeetCodeHOT100：78.子集
 * 解法：枚举，时间复杂度为O(n*2^n)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<(1<<n); i++){
            int x = i;
            List<Integer> tmp = new ArrayList<>();
            for(int j=0; j<n; j++){
                if((x&1)==1) tmp.add(nums[j]);
                x >>= 1;
            }
            res.add(tmp);
        }
        return res;
    }
}
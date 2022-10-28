/**
 * 功能描述
 * LeetCodeHOT100：15.三数之和
 * 解法：排序+双指针，时间复杂度为O(n^2)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = nums[l]+nums[r]+nums[i];
                if(sum == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    // System.out.println(nums[i]+" "+nums[l]+" "+nums[r]);
                    res.add(tmp);
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(sum > 0)
                    r--;
                else
                    l++;
            }
        }
        return res;
    }
}
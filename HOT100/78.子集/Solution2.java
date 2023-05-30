/**
 * 功能描述
 * LeetCodeHOT100：78.子集
 * 解法：dfs，时间复杂度为O(n*2^n)
 */
class Solution {

    public static List<List<Integer>> res;

    public static void dfs(int p, List<Integer> tmp, int n, int[] nums){
        if(p==n){
            res.add(new ArrayList(tmp));
            return ;
        }
        tmp.add(nums[p]);
        dfs(p+1, tmp, n, nums);
        tmp.remove(tmp.size()-1);
        dfs(p+1, tmp, n, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums.length, nums);
        return res;
    }
}
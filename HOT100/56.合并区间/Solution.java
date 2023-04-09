/**
 * 功能描述
 * LeetCodeHOT100：56.合并区间
 * 解法：排序+双指针，遍历更新当前区间，时间复杂度为O(n*logn)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1,e2)->(e1[0]==e2[0]?(e1[1]-e2[1]):(e1[0]-e2[0])));
        int[] tmp = new int[]{intervals[0][0], intervals[0][1]};
        List<int[]> list = new ArrayList<>();

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=tmp[1]){
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
            else{
                list.add(new int[]{tmp[0], tmp[1]});
                tmp[0] = intervals[i][0];
                tmp[1] = intervals[i][1];
            }
        }
        list.add(new int[]{tmp[0], tmp[1]});
        int[][] res = list.toArray(new int[list.size()][]);
        return res;
    }
}
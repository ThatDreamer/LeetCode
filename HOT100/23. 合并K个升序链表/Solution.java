/**
 * 功能描述
 * LeetCodeHOT100：23.合并K个升序的链表
 * 解法：分治，时间复杂度为O(kn×logk)
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return merge_sort(lists, 0, n-1);
    }

    public ListNode merge_sort(ListNode[] lists, int l, int r){
        if(l==r)
            return lists[l];
        int mid = (l+r)/2;
        ListNode left = merge_sort(lists, l, mid);
        ListNode right = merge_sort(lists, mid+1, r);
        return mergeTwoLists(left, right);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
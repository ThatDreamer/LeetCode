class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        cur = head
        while cur:
            t = Node(cur.val)
            t.next = cur.next
            cur.next = t
            cur = t.next
        cur = head
        t = head.next
        ans = t
        while cur:
            if cur.random:
                t.random =  cur.random.next
            cur = t.next
            if not cur:
                t.next = None
                break

            # cur.next = t.next
            # if not cur.next: break
            t.next = cur.next
            t = cur.next
        return ans
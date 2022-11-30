# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        answer = ListNode()
        def solve(list1, list2, answer, carry):
            digit = list1.val + list2.val + carry
            answer.val = digit % 10
            if list1.next == None and list2.next == None and digit // 10 == 0:
                return
            answer.next = ListNode()
            solve(list1.next if list1.next else ListNode(), list2.next if list2.next else ListNode(), answer.next, digit // 10)
        
        solve(l1, l2, answer, 0)
        
        return answer

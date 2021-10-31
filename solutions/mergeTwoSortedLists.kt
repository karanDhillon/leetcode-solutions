class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var firstHead: ListNode? = l1
        var secondHead: ListNode? = l2
        var outputHead: ListNode? = ListNode(-101)
        var outputRoot: ListNode? = outputHead
        
        while (firstHead != null || secondHead != null) {
            if (firstHead != null && secondHead != null) {
                if (firstHead.`val` <= secondHead.`val`) {
                    outputHead?.next = firstHead
                    outputHead = outputHead?.next
                    firstHead = firstHead?.next
                } else {
                    outputHead?.next = secondHead
                    outputHead = outputHead?.next
                    secondHead = secondHead?.next
                }
            } else {
                // One of the heads is null
                if (firstHead != null) {
                    outputHead?.next = firstHead
                    outputHead = outputHead?.next
                    firstHead = firstHead?.next
                } else {
                    outputHead?.next = secondHead
                    outputHead = outputHead?.next
                    secondHead = secondHead?.next
                }
            }
        }
        
        return outputRoot?.next
    }
}
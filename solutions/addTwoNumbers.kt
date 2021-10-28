class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var output: ListNode? = null
        var carry = 0
        
        return if (l1 == null && l2 == null) output
        else {
            output = ListNode(0)
            
            while (l1 != null || l2 != null) {
                var l1Value = 0
                var l2Value = 0
                
                l1?.let { l1Value = it.`val` }
                l2?.let { l2Value = it.`val` }
                
                val sum = l1Value + l2Value + carry
                carry = 0
                
                if (sum >= 10) {
                    val unitPlace = sum % 10
                    output.next = ListNode(unitPlace)
                    carry = 1
                } else {
                    output.next = ListNode(sum)
                }
            }
            
            output = output.next
            output
        }
    }
}
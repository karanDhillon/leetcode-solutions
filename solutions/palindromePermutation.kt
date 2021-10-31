class Solution {
    fun canPermutePalindrome(s: String): Boolean {
        val intArray = IntArray(128)
        
        s.toCharArray().forEach { 
            intArray[it.toInt()]++ 
        }
        
        var count = 0
        
        intArray.forEach { 
            count += it % 2
        }
        
        return count <= 1
    }
}
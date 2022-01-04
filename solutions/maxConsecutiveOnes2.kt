class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
      var maxConsecutiveOnes = 0
      var l = 0
      var zeroFlipped = 0
      
      for (r in 0 until nums.size) {
        if (nums[r] == 0) {
          ++zeroFlipped
        }
        
        while(l <= r && zeroFlipped > 1) {
          if (nums[l] == 0) --zeroFlipped
          
          ++l
        }
        
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, r - l + 1)
      }
      
      return maxConsecutiveOnes
    }
}
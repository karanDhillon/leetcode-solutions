class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
      var consecutiveOnesCount = 0
      var flippedZeroes = 0
      var l = 0
      
      for (r in 0 until nums.size) {
        if (nums[r] == 0) ++flippedZeroes
        
        while (l <= r && flippedZeroes > k) {
          if (nums[l] == 0) --flippedZeroes
          
          ++l
        }
        
        consecutiveOnesCount = Math.max(consecutiveOnesCount, r - l + 1)
      }
      
      return consecutiveOnesCount
    }
}
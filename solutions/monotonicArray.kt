class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
      var increasing = false
      var decreasing = false
      
      for (i in 0 until nums.size-1) {
        if (nums[i] > nums[i+1]) decreasing = true
        if (nums[i] < nums[i+1]) increasing = true
      }
      
      return if (increasing && decreasing) false else true
    }
}
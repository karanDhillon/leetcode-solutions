class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
      var max = 0
      var counter = 0
      
      for (i in 0 until nums.size) {
        if (nums[i] == 1) {
          counter++

          max = Math.max(max, counter)
        } else {
          counter  = 0
        }
      }
      
      return max
    }
}
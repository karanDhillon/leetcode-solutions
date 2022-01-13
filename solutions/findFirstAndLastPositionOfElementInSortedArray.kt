class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
      if (nums.size == 0) return intArrayOf(-1, -1)

      return intArrayOf(findStartIndex(nums, target), findEndIndex(nums, target))
    }
    
    fun findStartIndex(nums: IntArray, target: Int): Int {
      var l = 0
      var r = nums.size-1
      
      while (l <= r) {
        val m = l + (r-l)/2
        
        when {
          nums[m] > target -> r = m-1
          nums[m] < target -> l = m+1
          else -> {
            if (nums.getOrElse(m-1) { Int.MIN_VALUE } == target) r = m-1
            else return m
          }
        }
      }
      
      return -1
    }
    
    fun findEndIndex(nums: IntArray, target: Int): Int {
      var l = 0
      var r = nums.size-1
      
      while (l <= r) {
        val m = l + (r-l)/2
        
        when {
          nums[m] > target -> r = m-1
          nums[m] < target -> l = m+1
          else -> {
            if (nums.getOrElse(m+1) { Int.MIN_VALUE } == target) l = m+1
            else return m
          }
        }
      }
      
      return -1
    }
}
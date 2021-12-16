class Solution {
    fun search(nums: IntArray, target: Int): Int {
      if (nums.isEmpty()) return -1
      
      val s = findSmallestNumberIndex(nums)
      var l = 0
      var r = nums.size - 1      
          
      if (target >= nums[s] && target <= nums[r]) l = s
      else r = s
      
      while (l <= r) {
        val m = l + (r - l) / 2
        
        if (nums[m] == target) return m
        if (nums[m] < target) l = m + 1
        if (nums[m] > target) r = m - 1
      }
      
      return -1
    }
    
    fun findSmallestNumberIndex(nums: IntArray): Int {
      var l = 0
      var r = nums.size - 1
      
      while (l < r) {
        val m = l + (r - l) / 2
        
        if (nums[m] > nums[r]) {
          l = m + 1
        } else {
          r = m
        }
      }
      
      return l
    }
}
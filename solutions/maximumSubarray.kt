class Solution {
    fun maxSubArray(nums: IntArray): Int {
      var maxSum = nums.first()
      var currentSum = nums.first()
      
      for (i in 1 until nums.size) {
        currentSum = Math.max(nums[i], nums[i] + currentSum)
        maxSum = Math.max(currentSum, maxSum)
      }
  
      return maxSum
    }
}
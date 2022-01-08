class Solution {
    fun pivotIndex(nums: IntArray): Int {
      var totalSum = 0
      nums.forEach { totalSum += it }
      
      var leftSum = 0
      nums.forEachIndexed { index, num ->
        if (leftSum == totalSum - num - leftSum) return index
        else leftSum += num
      }
      
      return -1
    }
}
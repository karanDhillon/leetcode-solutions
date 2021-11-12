class Solution {
  fun nextPermutation(nums: IntArray): Unit {    
    var i = nums.size - 2
    while (i >=0 && nums[i] >= nums [i+1]) i--
    
    if (i >= 0) {
      var j = nums.size - 1
      while (j > i && nums[j] <= nums[i]) j--
      swap(nums, i, j)
    }
    
    reverse(nums, i+1)
  }
  
  fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
  }
  
  fun reverse(nums: IntArray, startIndex: Int) { 
    var start = startIndex
    var end = nums.size - 1
    
    while (start < end) {
      swap(nums, start, end)
      start++
      end--
    }
  }
}
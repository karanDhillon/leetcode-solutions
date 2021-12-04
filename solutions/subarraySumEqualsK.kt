class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
      var counter = 0
      
      var sum = 0
      val map = HashMap<Int, Int>().apply { put(0, 1) }
                         
      for (num in nums) {
        sum += num 
        counter += map.getOrElse(sum-k) { 0 }
        map.put(sum, map.getOrElse(sum) { 0 } + 1)
      }
      
      return counter
    }
}
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
      val map = HashMap<Int, Int>()
      
      nums.forEachIndexed { index, num ->
        if (map.contains(target - num)) {
          return intArrayOf(index, map.get(target - num)!!)
        }
        
        map.put(num, index)
      }
      
      return intArrayOf(0, 0) // Never returns as there is always a solution
    }
}  
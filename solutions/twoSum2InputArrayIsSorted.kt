class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
         val map = HashMap<Int, Int>()
      
      numbers.forEachIndexed { index, num ->
        if (map.contains(target - num)) {
          return intArrayOf(map.get(target - num)!!+1, index+1)
        }
        
        map.put(num, index)
      }
      
      return intArrayOf(0, 0) // Never returns as there is always a solution
    }
}
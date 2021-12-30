class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
      if (nums1.isEmpty()) return intArrayOf()
      
      val map = HashMap<Int, Int>()
      val stack = Stack<Int>()
      
      nums2.forEach { num ->
        while (stack.isNotEmpty() && stack.peek() < num) {
          map.put(stack.pop(), num)
        }
        
        stack.push(num)
      }
      
      val output = IntArray(nums1.size) { - 1}
      
      nums1.forEachIndexed { index, num ->
        if (map.contains(num)) {
          output[index] = map.getOrElse(num) { -1 }
        }          
      }
      
      return output
    }
}
class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
      val stack = Stack<Int>()
      val output = IntArray(nums.size) { -1 }
      
      for(i in 0 until nums.size * 2) {
        while (stack.isNotEmpty() && nums[stack.peek() % nums.size] < nums[i % nums.size]) {
          output[stack.pop() % nums.size] = nums[i % nums.size]
        }
        
        stack.push(i % nums.size)
      }
      
      return output
    }
}
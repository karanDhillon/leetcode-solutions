class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
      val output = IntArray(temperatures.size) { 0 }
      val stack = Stack<Int>()
      
      
      temperatures.forEachIndexed { index, temp ->
        while (stack.isNotEmpty() && temperatures[stack.peek()] < temp) {
          val popped = stack.pop()
          output[popped] = index - popped
        }
        
        stack.push(index)
      }
      
      return output
    }
}
class Solution {
  fun removeDuplicates(s: String): String {
    val stack = Stack<Char>()
    
    s.toCharArray().forEach { char ->
      if (stack.lastOrNull() == char) stack.pop()
      else stack.push(char) 
    }
    
    val output = StringBuilder()
    
    while (stack.isNotEmpty()) {
      output.append(stack.pop())
    }
    
    return output.toString().reversed()
  }
}
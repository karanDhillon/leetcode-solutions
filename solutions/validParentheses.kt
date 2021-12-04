class Solution {
    fun isValid(s: String): Boolean {
      val stack = Stack<Char>().apply { push('X') }
      val array = s.toCharArray()
      var flag = true
      var index = 0
      
      while (index < array.size && flag) {
        if (
          array[index] == '(' ||
          array[index] == '{' ||
          array[index] == '['
        ) {
          stack.push(array[index])
        } else {
          val top = stack.peek()
          
          when (array[index]) {
            ')' -> if (top != '(') flag = false else stack.pop()
            '}' -> if (top != '{') flag = false else stack.pop()
            ']' -> if (top != '[') flag = false else stack.pop()
          }
        }
        
        index++
      }
      
      stack.pop() // to pop placeholder 'X'
            
      return stack.isEmpty() && flag
    }
}
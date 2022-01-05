class Solution {
    fun minAddToMakeValid(s: String): Int {
      var moves = 0
      val stack = Stack<Char>()
      
      for (i in 0 until s.length) {
        if (s[i] == '(') stack.push('(')
        else {
          if (stack.isEmpty()) ++moves
          else stack.pop()
        }
      }
 
      return moves + stack.size
    }
}
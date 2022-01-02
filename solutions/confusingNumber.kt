class Solution {
    fun confusingNumber(n: Int): Boolean {
      val input = n.toString()
      val map = HashMap<Char, Char>().apply {
        put('0', '0')
        put('1', '1')
        put('6', '9')
        put('8', '8')
        put('9', '6')
      }      
      
      val sb = StringBuilder()
      
      for (i in input.length - 1 downTo 0) {
        if (!map.contains(input[i])) return false
        else sb.append(map.getOrElse(input[i]) { ' ' })
      }
      
      return sb.toString() != input
    }
}
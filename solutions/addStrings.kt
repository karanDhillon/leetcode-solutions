class Solution {
    fun addStrings(num1: String, num2: String): String {
      val sb = StringBuilder()
      
      val map = HashMap<Char, Int>().apply {
        put('0', 0)
        put('1', 1)
        put('2', 2)
        put('3', 3)
        put('4', 4)
        put('5', 5)
        put('6', 6)
        put('7', 7)
        put('8', 8)
        put('9', 9)
      }
      
      var f = num1.length - 1
      var s = num2.length - 1
      
      var carry = 0

      while (f >= 0 && s >= 0) {
        val add = map.getOrElse(num1[f]) { 0 } + map.getOrElse(num2[s]) { 0 } + carry
        
        if (add / 10 == 1) {
          sb.append(add % 10)
          carry = 1
        } else {
          sb.append(add)
          carry = 0
        }
        
        --f
        --s
      }
      
      while (f >= 0) {
        val add = map.getOrElse(num1[f]) { 0 } + carry
        
        if (add / 10 == 1) {
          sb.append(add % 10)
          carry = 1
        } else {
          sb.append(add)
          carry = 0
        }

        --f
      }
      
      while (s >= 0) {
        val add = map.getOrElse(num2[s]) { 0 } + carry
        
        if (add / 10 == 1) {
          sb.append(add % 10)
          carry = 1
        } else {
          sb.append(add)
          carry = 0
        }

        --s
      }

      if (carry == 1) sb.append('1')
      
      return sb.toString().reversed()
    }
}
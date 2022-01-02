class Solution {
    fun isStrobogrammatic(num: String): Boolean {
      val map = HashMap<Char, Char>().apply {
        put('0', '0')
        put('1', '1')
        put('6', '9')
        put('8', '8')
        put('9', '6')
      }
      var l = 0
      var r = num.length - 1
      
      while (l <= r) {
        if (
          !map.contains(num[l]) ||
          !map.contains(num[r]) ||
          map.getOrElse(num[l]) { ' ' } != num[r] ||
          map.getOrElse(num[r]) { ' ' } != num[l]
        ) return false
        
        ++l
        --r
      }
      
      return true
    }
}
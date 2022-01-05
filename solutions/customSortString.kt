class Solution {
    fun customSortString(order: String, s: String): String {
      val map = HashMap<Char, Int>()
      
      for (i in 0 until s.length) {
        map.put(s[i], map.getOrElse(s[i]) {0} + 1)
      }
      
      val sb = StringBuilder()
      
      for (i in 0 until order.length) {
        val char = order[i]
        
        if (map.contains(char)) {
          for (times in 0 until map.getOrElse(char) {0}) {
            sb.append(char)
          }
          
          map.remove(char)
        }
      }
      
      map.entries.forEach { entry ->
        val key = entry.key
        val value = entry.value

        for (i in 0 until value) {
          sb.append(key)
        }
      }
      
      return sb.toString()
    }
}
class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
      val map = HashMap<Char, Int>().apply {
        order.toCharArray().forEachIndexed { index, char ->
          put(char, index + 1)
        }
      }
      
      for (i in 0 until words.size - 1) {
        val first = words[i]
        val second = words[i + 1]
        
        if (first.length <= second.length) {
          var p = 0
          
          while (p < first.length) {
            if (map.getOrElse(first[p]) { 0 } > map.getOrElse(second[p]) { 0 }) {
              return false
            } else if (map.getOrElse(first[p]) { 0 } < map.getOrElse(second[p]) { 0 }) {
              break
            } else {
              ++p
            }
          }
        } else { // Second is smaller
          var p = 0
          
          while (p < second.length) {
            if (map.getOrElse(first[p]) { 0 } > map.getOrElse(second[p]) { 0 }) {
              return false
            } else if (map.getOrElse(first[p]) { 0 } < map.getOrElse(second[p]) { 0 }) {
              break
            } else {
              ++p
            }
          }
          
          if (p == second.length) return false
        }
      }
      
      return true
    }

}
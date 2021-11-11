class Solution {
    fun minRemoveToMakeValid(s: String): String {
      var counter = 0
      
      var frontToEnd = StringBuilder()
      s.toCharArray().forEach {
        when (it) {
          '(' -> {
            counter++
            frontToEnd.append(it)
          }
          ')' -> {
            if (counter > 0) {
              counter--
              frontToEnd.append(it)
            }
          }
          else -> frontToEnd.append(it)
        }
      }
      
      counter = 0
      
      var endToFront = StringBuilder()
      for (i in frontToEnd.length-1 downTo 0) {  
        when (frontToEnd[i]) {
          '(' -> {
            if (counter > 0) {
              counter--
              endToFront.append(frontToEnd[i])
            }
          }
          ')' -> {
            counter++
            endToFront.append(frontToEnd[i])
          }
          else -> endToFront.append(frontToEnd[i])
        }        
      } 
      
      return endToFront.toString().reversed()
    }
}  
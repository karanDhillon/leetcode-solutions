class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
      if (strs.isEmpty()) return ""
      
      var lcp = strs[0]
      
      for (i in 1 until strs.size) {
        while(strs[i].indexOf(lcp) != 0) {
            lcp = lcp.substring(0, lcp.length - 1)
        }
      }
      
      return lcp
    }
}
class Solution {
    fun validPalindrome(s: String): Boolean {
      var l = 0
      var r = s.length - 1
      
      while (l <= r) {
        if (s[l] != s[r]) {
          return isPalindrome(s, l, r-1) || isPalindrome(s, l+1, r)
        }
        
        l++
        r--
      }
      
      return true
    }
    
    fun isPalindrome(
      s: String,
      l: Int,
      r: Int
    ): Boolean {
      var start = l
      var end = r
      
      while (start <= end) {
        if (s[start] != s[end])
          return false
        
        start++
        end--
      }
      
      return true
    }
}
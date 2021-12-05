class Solution {
    fun longestPalindrome(s: String): String {
      var longestSubstring = ""
      var longestSubstringSize = 0
      val charArray = s.toCharArray()
      
      charArray.forEachIndexed { index, char ->
        var leftIndex = index
        var rightIndex = index
        
        while (
          leftIndex >= 0 &&
          rightIndex < charArray.size &&
          charArray[leftIndex] == charArray[rightIndex]
        ) {
          if (rightIndex - leftIndex + 1 > longestSubstringSize) {
            longestSubstringSize = rightIndex - leftIndex + 1
            longestSubstring = s.substring(leftIndex, rightIndex + 1)
          }
          
          leftIndex--
          rightIndex++
        }
        
        leftIndex = index
        rightIndex = index + 1
        
        while (
          leftIndex >= 0 &&
          rightIndex < charArray.size &&
          charArray[leftIndex] == charArray[rightIndex]
        ) {
          if (rightIndex - leftIndex + 1 > longestSubstringSize) {
            longestSubstringSize = rightIndex - leftIndex + 1
            longestSubstring = s.substring(leftIndex, rightIndex + 1)
          }
          
          leftIndex--
          rightIndex++
        }
      }
      
      return longestSubstring
    }
}
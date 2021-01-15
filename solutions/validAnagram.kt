class Solution {
    // s and t will always contain lowercase alphabets only.
    fun isAnagram(s: String, t: String): Boolean {
        var flag = true
        
        val firstMap = HashMap<Char, Int>()
        val secondMap = HashMap<Char, Int>()
        
        val firstCharArray = s.toCharArray()
        val secondCharArray = t.toCharArray()
        
        firstCharArray.forEach { char ->
            if(firstMap[char] != null) firstMap.put(char, firstMap[char]!! + 1)
            else firstMap.put(char, 1)
        }
        
        secondCharArray.forEach { char ->
            if(secondMap[char] != null) secondMap.put(char, secondMap[char]!! + 1)
            else secondMap.put(char, 1)
        }
        
         firstMap.forEach { (char, value) -> 
            if(secondMap[char] == null) flag = false
            else {
                if(secondMap[char] != value) flag = false

                secondMap.remove(char)
            }
         }
         
         return if(secondMap.size != 0) false else flag
    }
}
class Solution {
    fun plusOne(digits: IntArray): IntArray {
      val output = ArrayList<Int>()
      var carry = 0
      
      for (i in digits.size - 1 downTo 0) {
        if (i == digits.size - 1) {
          val afterAdd = digits[i] + 1
          
          if (afterAdd/10 == 1) {
            carry = 1
            output.add(0, 0)
          } else {
            carry = 0
            output.add(0, afterAdd)
          }
        }
        else {
          if (carry == 1) {
            val afterAdd = digits[i] + 1
            
            if (afterAdd/10 == 1) {
              carry = 1
              output.add(0, 0)
            } else {
              carry = 0
              output.add(0, afterAdd)
            }
          } else {
            output.add(0, digits[i])
          }
        }
      }
      
      if (carry == 1) {
        output.add(0, 1)
      }
      
      return output.toIntArray()
    }
}
class Solution {
    fun leftMostColumnWithOne(binaryMatrix:BinaryMatrix):Int {
      var oneIndex = Int.MAX_VALUE
      
      for (i in 0 until binaryMatrix.dimensions().first()) {
        var l = 0
        var r = binaryMatrix.dimensions().last() - 1
        
        while (l < r) {
          val m = l + (r - l) / 2
          
          if (binaryMatrix.get(i, m) == 0) l = m + 1 
          else  r = m
        }
        
        if (binaryMatrix.get(i, l) == 1 && l < oneIndex)
          oneIndex = l
      }
      
      return if (oneIndex == Int.MAX_VALUE) -1 else oneIndex
    }
}
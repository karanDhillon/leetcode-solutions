class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
      var plantsLeft = n 
      
      for (i in 0 until flowerbed.size) {
        if (
          flowerbed.getOrElse(i - 1) { 0 } == 0 &&
          flowerbed.getOrElse(i + 1) { 0 } == 0 &&
          flowerbed[i] == 0  
        ) {
          flowerbed[i] = 1
          --plantsLeft
        } 
      }
      
      return if (plantsLeft > 0) false else true
    }
}  
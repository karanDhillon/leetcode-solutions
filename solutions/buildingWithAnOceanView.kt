class Solution {
    fun findBuildings(heights: IntArray): IntArray {
      var currentMax = -1
      val list = ArrayList<Int>()
      
      for (i in heights.size-1 downTo 0) {
        if (heights[i] > currentMax) {
          list.add(i)
          currentMax = heights[i]
        }
      }
      
      return list.reversed().toIntArray()
    }
}
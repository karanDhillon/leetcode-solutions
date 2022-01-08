class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
      val diagonals = ArrayList<List<Int>>()
      
      for (c in 0 until mat[0].size) {
        var col = c
        var row = 0
        
        val diagonal = ArrayList<Int>()
        
        while (row <= mat.size - 1 && col >= 0) {
          diagonal.add(mat[row][col])
          ++row
          --col
        }
        
        diagonals.add(diagonal)
      }
      
      for (r in 1 until mat.size) {
        var col = mat[0].size - 1
        var row = r
        
        val diagonal = ArrayList<Int>()
        
        while (row <= mat.size - 1 && col >= 0) {
          diagonal.add(mat[row][col])
          ++row
          --col
        }
        
        diagonals.add(diagonal)  
      }
 
      val zigzag = ArrayList<Int>()
      
      diagonals.forEachIndexed { index, list ->
        if (index % 2 == 0) list.reversed().forEach { zigzag.add(it) }
        else list.forEach { zigzag.add(it) }
      }
      
      return zigzag.toIntArray()
    }
}
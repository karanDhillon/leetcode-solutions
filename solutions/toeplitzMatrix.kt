class Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
      for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
          if (i + 1 < matrix.size && j + 1 < matrix[0].size)
            if (matrix[i][j] != matrix[i+1][j+1]) return false
        }
      }
      
      return true
    }
}
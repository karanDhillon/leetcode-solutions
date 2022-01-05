class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
      var p = 0
      
      for (r in 0 until grid.size) {
        for (c in 0 until grid[0].size) {
          if (grid[r][c] == 1) {
            val t = if(r-1 < 0 || grid[r-1][c] == 0) 1 else 0
            val b = if(r+1 >= grid.size || grid[r+1][c] == 0) 1 else 0
            val l = if(c-1 < 0 || grid[r][c-1] == 0) 1 else 0
            val r = if(c+1 >= grid[0].size || grid[r][c+1] == 0) 1 else 0
          
            p += t+b+l+r 
          }
        }
      }
      
      return p
    }
}
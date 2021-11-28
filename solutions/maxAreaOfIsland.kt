class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
      val r = grid.size
      val c = grid.first().size
      
      val visited = mutableSetOf<String>()
      var max = 0
      
      for (i in 0 until r) {
        for (j in 0 until c) {
          val area = explore(grid, i, j, visited)
          
          if (area > max) {
            max = area
          }
        }
      }
      
      return max
    }
    
    fun explore(
      grid: Array<IntArray>,
      row: Int,
      col: Int,
      visited: MutableSet<String>
    ): Int {
      val position = "$row,$col"
      val rowInbounds = 0 <= row && row < grid.size
      val colInbounds = 0 <= col && col < grid.first().size
      
      if (!rowInbounds || !colInbounds) return 0
      if (grid[row][col] == 0) return 0
      if (visited.contains(position)) return 0
    
      visited.add(position)
    
      var size = 1
    
      size += explore(grid, row-1, col, visited)
      size += explore(grid, row+1, col, visited)
      size += explore(grid, row, col-1, visited)
      size += explore(grid, row, col+1, visited)
      
      return size
    }
}
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
      var count = 0
      
      val rows = grid.size
      val cols = grid.first().size
    
      val visited = mutableSetOf<String>()
      
      for (i in 0 until rows)
        for (j in 0 until cols)
          if (explore(grid, i, j, visited)) count++
      
      return count
    }
    
    fun explore(
      grid: Array<CharArray>,
      row: Int,
      col: Int,
      visited: MutableSet<String>
    ): Boolean {
      val position = "$row,$col"
      val rowInbounds = 0 <= row && row < grid.size
      val colInbounds = 0 <= col && col < grid.first().size
      
      if (!rowInbounds || !colInbounds) return false
      if (grid[row][col] == '0') return false
      if (visited.contains(position)) return false
    
      visited.add(position)
      
      explore(grid, row-1, col, visited)
      explore(grid, row+1, col, visited)
      explore(grid, row, col-1, visited)
      explore(grid, row, col+1, visited)
      
      return true
    }
}
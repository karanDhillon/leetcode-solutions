class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
      val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
      val queue = LinkedList<Pair<Int, Int>>()
      
      if (grid[0][0] == 1) return -1
      
      queue.add(Pair(0, 0))
      
      val offsets = arrayOf(
        Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1),
        Pair(1, 1), Pair(-1, -1), Pair(1, -1), Pair(-1, 1)
      )

      var counter = 0
      
      while (queue.isNotEmpty()) {        
        val queueCount = queue.size
        
        for (i in 0 until queueCount) {
          val polled = queue.poll()
          
          if (
            polled.first == grid.size - 1 && 
            polled.second == grid[0].size - 1
          ) return ++counter          
          
          if (visited[polled.first][polled.second] == false) {
            visited[polled.first][polled.second] = true
        
            offsets.forEach { offset ->
            val newX = polled.first + offset.first
            val newY = polled.second + offset.second

            if (
              0 <= newX && newX < grid.size && 
              0 <= newY && newY < grid[0].size &&
              visited[newX][newY] == false &&
              grid[newX][newY] == 0
            ) {
              queue.add(Pair(newX, newY))
            }
          }
          }
        }
        
        ++counter
      }
      
      return if (visited[grid.size - 1][grid[0].size - 1] == true) counter
      else -1
    }
}
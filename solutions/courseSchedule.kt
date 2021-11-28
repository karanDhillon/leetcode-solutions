class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
      val map = createMap(prerequisites)
      val visited = mutableSetOf<Int>()
      var flag = true
      
      map.keys.forEach { key ->
        if (isSchedulePossible(map, key, visited) == false) {
          flag = false
        }
      }
      
      return flag
    }
    
    fun isSchedulePossible(
      map: HashMap<Int, IntArray>,
      course: Int,
      visited: MutableSet<Int>
    ): Boolean {
      if (map.get(course) != null) {
        if (map.get(course)!!.isEmpty()) return true
      }
      
      if (visited.contains(course)) return false
      visited.add(course)
      
      if (map.get(course) != null) {
        map.get(course)!!.forEach { prerequisite ->
          if (isSchedulePossible(map, prerequisite, visited) == false) return false
        }
      }
      
      if (map.get(course) != null) {
        map.set(course, intArrayOf())
      }
      visited.remove(course)
      
      return true
    }
    
    fun createMap(data: Array<IntArray>): HashMap<Int, IntArray> {
      val map = HashMap<Int, IntArray>()
      
      data.forEach { intArray ->
        val course: Int = intArray[0]
        val required: Int = intArray[1]
        
        if (map.contains(course)) {
          map.set(course, map.get(course)!! + intArrayOf(required))
        } else {
          map.set(course, intArrayOf(required))
        }
      }
      
      return map
    }
}
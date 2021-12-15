class Solution {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
      if (intervals.isEmpty()) return true
      
      intervals.sortBy { intArray -> intArray.first() }
      
      for (i in 0 until intervals.size - 1) {
        if (intervals[i][1] > intervals[i+1][0]) {
          return false
        }
      }
      
      return true
    }
}
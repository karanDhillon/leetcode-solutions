class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> { 
      val output = ArrayList<IntArray>()
      var new = newInterval
    
      intervals.forEachIndexed { index, interval ->
        if (new[1] < interval[0]) {
          output.add(new)
          intervals.copyOfRange(index, intervals.size).forEach { output.add(it) }
          
          return output.toTypedArray()
        }
        else if (new[0] > interval[1]) {
          output.add(interval)
        }
        else {
          new = intArrayOf(Math.min(new[0], interval[0]), Math.max(new[1], interval[1]))
        }
      }
      
      output.add(new) // to handle the case where newInterval lies after given intervals or at last
        
      return output.toTypedArray()
    }
}
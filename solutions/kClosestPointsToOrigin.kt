class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
      val comparator = object: Comparator<DoubleArray> {
        override fun compare(o1: DoubleArray, o2: DoubleArray): Int {
          return if (o1.first() < o2.first()) -1
          else if (o1.first() > o2.first()) 1
          else 0
        }
      }
      val pq = PriorityQueue<DoubleArray>(comparator)
      
      for (i in 0 until points.size) {
        val d = Math.sqrt(Math.pow(points[i].first().toDouble(), 2.0) + Math.pow(points[i].last().toDouble(), 2.0))
        
        pq.offer(doubleArrayOf(d, i.toDouble()))  
      }
      
      val output = ArrayList<IntArray>()
      
      for (i in 0 until k) {
        val polledIndex = pq.poll().last().toInt()
        output.add(points[polledIndex])
      }
      
      return output.toTypedArray()
    }
}
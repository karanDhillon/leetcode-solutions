class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
      val comparator = object: Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
          return if (o1 > o2) -1
          else if (o1 < o2) 1
          else 0
        }
      }
      val pq = PriorityQueue<Int>(comparator)
      
      score.forEach { pq.offer(it) }
      
      val map = HashMap<Int, String>()
      var rank = 1
      
      while (pq.isNotEmpty()) {
        val polled = pq.poll()
        
        if (rank == 1) map.put(polled, "Gold Medal")
        else if (rank == 2) map.put(polled, "Silver Medal")
        else if (rank == 3) map.put(polled, "Bronze Medal")
        else map.put(polled, "$rank")
        
        ++rank
      }
      
      val output = ArrayList<String>()
      
      score.forEach { output.add(map.getOrElse(it) { "" }) }
      
      return output.toTypedArray()
    }
}
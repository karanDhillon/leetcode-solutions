class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
      val comparator = object: Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
          return if (o1 > o2) -1
          else if (o1 < o2) +1
          else 0
        }
      }
      val pq = PriorityQueue<Int>(comparator)
      
      stones.forEach { pq.offer(it) }

      while (pq.size > 1) {
        pq.offer(Math.abs(pq.poll()-pq.poll()))
      }
      
      return pq.poll()
    }
}
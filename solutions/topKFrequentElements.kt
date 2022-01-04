class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
      val map = HashMap<Int, Int>()
      
      nums.forEach { num ->
        map.put(num, map.getOrElse(num) {0} + 1)
      }
  
      val pqc = object: Comparator<Pair<Int, Int>> {
        override fun compare(o1: Pair<Int, Int>, o2: Pair<Int, Int>): Int {
          return if (o1.second > o2.second) 1
          else if (o1.second < o2.second) -1
          else 0
        }
      }
      val pq = PriorityQueue<Pair<Int, Int>>(pqc)
      
      map.entries.forEach { entry ->
        pq.offer(Pair(entry.key, entry.value))
        
        if (pq.size > k) 
          pq.poll()
      }
      
      val output = ArrayList<Int>()
      
      for (i in 0 until k) {
        output.add(pq.poll().first)
      }
      
      return output.toIntArray()
    }
}
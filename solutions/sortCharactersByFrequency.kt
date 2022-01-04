class Solution {
    fun frequencySort(s: String): String {
      val map = HashMap<Char, Int>()
      
      for (i in 0 until s.length) {
        map.put(s[i], map.getOrElse(s[i]) {0} + 1)
      }
      
      val pqc = object: Comparator<Pair<Char, Int>> {
        override fun compare(o1: Pair<Char, Int>, o2: Pair<Char, Int>): Int {
          return if (o1.second > o2.second) 1
          else if (o1.second < o2.second) -1
          else 0
        }
      }
      val pq = PriorityQueue<Pair<Char, Int>>(pqc.reversed())
      
      map.entries.forEach { entry ->
        pq.offer(Pair(entry.key, entry.value))
      }
      
      val sb = StringBuilder()
      
      while (pq.isNotEmpty()) {
        val polledPair = pq.poll()
        
        for (i in 0 until polledPair.second) {
          sb.append(polledPair.first)
        }
      }
      
      return sb.toString()
    }
}
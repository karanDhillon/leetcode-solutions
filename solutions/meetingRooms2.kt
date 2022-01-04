class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
      var roomsRequired = 0  
        val pqc = object: Comparator<IntArray> {
            override fun compare(o1: IntArray, o2: IntArray): Int {
                return if (o1[1] > o2[1]) 1
                else if (o1[1] < o2[1]) -1
                else 0
            }
        }
        val ac = object: Comparator<IntArray> {
            override fun compare(o1: IntArray, o2: IntArray): Int {
                return if (o1[0] > o2[0]) 1
                else if (o1[0] < o2[0]) -1
                else 0
            }
        } 
        
        val pq = PriorityQueue(pqc)
        intervals.sortWith(ac)
        
        intervals.forEach { interval ->
            while (pq.isNotEmpty() && pq.peek()[1] <= interval[0]) {
                pq.poll()
            }

            pq.offer(interval)
            
            roomsRequired = Math.max(roomsRequired, pq.size)
        }

        return roomsRequired
    }
}

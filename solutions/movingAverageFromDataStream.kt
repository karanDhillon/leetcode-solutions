class MovingAverage(val size: Int) {
  val q = LinkedList<Int>()
  var qSum = 0.0

    fun next(`val`: Int): Double {
      if (q.size < size) {
        q.offer(`val`)
        qSum += `val`
      } else {
        val polled = q.poll()
        q.offer(`val`)
        qSum -= polled
        qSum += `val`
      }
      
      return qSum/q.size
    }
}
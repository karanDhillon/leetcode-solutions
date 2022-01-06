class LRUCache(private val capacity: Int) {
  val map = HashMap<Int, Node>()
  val start = Node(-1, -1)
  val end = Node(-1, -1)
  
  init {
    start.next = end
    end.prev = start
  }
  
  fun get(key: Int): Int {
    if (map.contains(key)) {
      val node = map.get(key)!!
      remove(node)
      moveToFront(node)
      
      return node.value
    }
    
    return -1
  }

  fun put(key: Int, value: Int) {
    if (map.contains(key)) {
      remove(map.get(key)!!)
    }
    
    val node = Node(key, value)
    map.put(key, node)
    moveToFront(node)

    if (map.size > capacity) {
      val last = end.prev!!
      remove(last)
      map.remove(last.key)
    }
  }
  
  private fun remove(node: Node) {
    val next = node.next!!
    val prev = node.prev!!
    
    prev.next = next
    next.prev = prev
  }
  
  private fun moveToFront(node: Node) {
    val first = start.next!!
    node.next = first
    node.prev = start
    start.next = node
    first.prev = node
  }
}

class Node(val key: Int, val value: Int) {
  var next: Node? = null
  var prev: Node? = null
}

/*Program in Scala for BFS Tree*/

object bfsTree extends App {
  case class Tree(value: Int, left: Option[Tree], right: Option[Tree])
  //Creating a tree
  val myTree: Tree =
    Tree(1,
      Some(Tree(3,
        Some(Tree(2,
          Some(Tree(9, None, None)),
          Some(Tree(6, None, None))
        )),
        Some(Tree(4,
          None,
          Some(Tree(8, None, None))
        ))
      )),
      Some(Tree(5,
        None,
        Some(Tree(7, None, None))
      ))
    )
  //Parsing and dispalying the tree
  def TreePrinter(rootNode: Tree): Unit = {
    var temp     = List.empty[Tree]
    var list     = List.empty[Tree]
    var child    = List.empty[Tree]
    var line     = ""
    list = list.+:(rootNode)
    while(list.nonEmpty) {
      while(list.nonEmpty) {
        val node = list.head
        list = list.drop(1)
        line = line + node.value + " "
        node.left.map(node => child = child.:+(node))
        node.right.map(node => child = child.:+(node))
      }
      //printing the tree
      println(line)
      line = ""
      temp = child
      child = list
      list = temp
    }
  }
  TreePrinter(myTree)
}
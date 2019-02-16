//following program will perform BFS on a tree
//tree structure is
//        1
//       /\
//      3  5
//     / \  \
//    2  4   7
//   / \      \
//  9  6      8

object bfsTree extends App {
  case class Tree(value: Int, left: Option[Tree], right: Option[Tree])
  //creating tree
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
  //parsing and printing tree
  def TreePrinter(rootNode: Tree): Unit = {
    var temp     = List.empty[Tree]
    var list     = List.empty[Tree]
    var children = List.empty[Tree]
    var line     = ""
    list = list.+:(rootNode)
    while(list.nonEmpty) {
      while(list.nonEmpty) {
        val node = list.head
        list = list.drop(1)
        line = line + node.value + " "
        node.left.map(node => children = children.:+(node))
        node.right.map(node => children = children.:+(node))
      }
      println(line)
      line = ""
      temp = children
      children = list
      list = temp
    }
  }
  TreePrinter(myTree)
}
/*
@readCase "print and println are used to customize the output screen"
*/

/*
insert this in build.sbt to run this program
libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.9" % "test->default",
  "org.mockito" % "mockito-core" % "1.9.5"
)
 */

//add main method and call testRangeMinQuery to execute code
import org.junit.Test


class TestRangeMinQuery {

  @Test
  def testRangeMinQuery(): Unit = {
    val M = 100001
    val points = List(10, 20, 30, 40, 11, 22, 33, 44, 15, 5)
    val rootNode = initTree(SegTree.buildTree[Int](0, points.length-1, M), points, gMin)

    val v0 = SegTree.query(rootNode, 0, 5, gMin)
    val v1 = SegTree.query(rootNode, 1, 2, gMin)
    val v2 = SegTree.query(rootNode, 8, 9, gMin)
    val v3 = SegTree.query(rootNode, 0, 9, gMin)
    val v4 = SegTree.query(rootNode, 4, 6, gMin)

    assert(10 == v0)
    assert(20 == v1)
    assert(5 == v2)
    assert(5 == v3)
    assert(11 == v4)
  }

  /**
    * Set aggregation function as `Math.min`.
    */

  def gMin(a:Int, b:Int): Int = Math.min(a, b)

  def initTree[T](rootNode: TreeNode[T], points: List[T], f:(T, T) => T): TreeNode[T] = {
    var root = rootNode
    for ((p, idx) <- points.zipWithIndex) {
      root = SegTree.insertPoint(root, idx, p, f)._1
    }
    root
  }
}
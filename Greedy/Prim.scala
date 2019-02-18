
//this program will find minimum path between two vertices by using prim's algorithm
//@@@@find graph.txt file for reading graph structure (necessary)

import scala.collection.mutable.ArrayBuffer
import java.io._
import scala.io.Source
import scala.collection.mutable.Map
import scala.collection.mutable.Set

class Edge {
  var a: Char = '0'
  var b: Char = '0'
  var weight = 0
  def this(a: Char, b: Char, weight: Int) {
    this()
    this.a = a
    this.b = b
    this.weight = weight
  }
  override def toString(): String = a.toString + " --- " + b.toString + ", weight = " + weight.toString
}

class Prim {
  var vertices: ArrayBuffer[Char] = new ArrayBuffer[Char]()
  var edges: ArrayBuffer[Edge] = new ArrayBuffer[Edge]()
  var map = Map[Char, ArrayBuffer[Char]]()
  var tree: ArrayBuffer[Edge] = new ArrayBuffer[Edge]()
  def this(fileName: String) {
    this()
    //read file
    val inputFile: File = new File(fileName)
    if (!inputFile.exists()) {
      println(fileName + " does not exist. ")
      System.exit(-1)
    }
    //formatting input file
    val source = Source.fromFile(inputFile)
    for (l <- source.getLines) {
      val line = l.replace(":", "").replace(",", "")
      val array = line.split(" ")
      //vertices count
      val numberOfAdjacentVertices = (array.length - 1)/2
      vertices.append(array(0)(0))
      var adj = new ArrayBuffer[Char]()
      //adding weight to edges and adjacent vertices
      for (i <- 0 until numberOfAdjacentVertices) {
        adj.append(array(i + 1)(0))
        val weight = array(i + 1 + numberOfAdjacentVertices).toInt
        val edge = new Edge(array(0)(0), array(i+1)(0), weight)
        edges.append(edge)
      }
      //mapping graph
      map(array(0)(0)) = adj
    }
    source.close()
  }
  //getting edge for two vertices
  def getEdge(start: Char, end: Char): Edge = {
    for (edge <- edges) {
      if (edge.a == start && edge.b == end) return edge
      if (edge.a == end && edge.b == start) return edge
    }
    new Edge()
  }
  def search(source: Char) {
    assert(vertices.contains(source))
    var inside = new ArrayBuffer[Char]()
    var outside = new ArrayBuffer[Char]()
    inside.append(source)
    for (v <- vertices) if (!inside.contains(v)) outside.append(v)
    var count = 0
    while(outside.nonEmpty && count <= edges.length/2) {
      count = count + 1
      var cuts = new ArrayBuffer[Edge]()
      for (v <- inside) {
        val out_adj = map(v).filter(outside.contains(_))
        for (i <- out_adj.indices) {
          val start = v
          val end = out_adj(i)
          cuts.append(getEdge(start, end))
        }
      }
      //defining according to weight
      var minWeight = cuts(0).weight
      var minIndex = 0
      for (i <- cuts.indices) {
        if (minWeight > cuts(i).weight) {
          minWeight = cuts(i).weight
          minIndex = i
        }
      }
      //defining according to minimum edge
      val minEdge = cuts(minIndex)
      tree.append(minEdge)
      if (inside.contains(minEdge.a)) {
        inside.append(minEdge.b)
        outside -= minEdge.b
      } else {
        inside.append(minEdge.a)
        outside -= minEdge.a
      }
    }
    var treeVertices = Set[Char]()
    for (edge <- tree) {
      treeVertices += edge.a
      treeVertices += edge.b
    }
    assert(treeVertices.size == vertices.length)
  }
}
object Prim extends App{
    val prim = new Prim("src/graph.txt")
    prim.search(prim.vertices(0))
    for (t <- prim.tree) println(t)
}
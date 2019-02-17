# Given a graph and a source vertex in graph
# Find shortest paths from source to all vertices in the given graph
from collections import defaultdict


# Initialize class Graph to create a graph
class Graph:
    # Initialize an undirected graph
    def __init__(self, directed=False):
        self.graph = defaultdict(list)
        self.directed = directed

    # define a function add_edge to add edges to the graph
    def add_edge(self, start, end, weight):
        # The function takes in the start_vertex and the end_vertex
        # The weight is appended to the dict[list] containing start_vertex and end_vertex
        self.graph[start].append([end, weight])
        # Append weight to the start and end vertex when it is an undirected graph only
        if self.directed is False:
            self.graph[end].append([start, weight])
        else:
            self.graph[end] = self.graph[end]

    # define a function to find the minimum from a source node to visitor node
    def min_source_visited(self, distance_from_source, visited_node):
        # initialize the minimum as infinity
        minimum = float('inf')
        index = 0
        # iterate through vertices in the graph
        for v in self.graph.keys():
            # if a vertex v exists in the graph then check if the node has been visited or not
            if visited_node[v] is False and distance_from_source[v] < minimum:
                # if it has not been visited and the distance from source to the visitor node is minimum
                # then reassign the weight of visiting vertex from the distance from source to minimum
                minimum = distance_from_source[v]
                index = v
        return index

    # define a function djikstra that takes in input as source vertex and returns the distance from source vertex and the parent vertex
    def dijkstra(self, source_node):
        visited_node = {i: False for i in self.graph}
        distance_from_source = {i: float('inf') for i in self.graph}
        parent = {i: None for i in self.graph}
        # set distance of src vertex from itself 0
        distance_from_source[source_node] = 0
        # find shortest path for all vertices
        for i in range(len(self.graph) - 1):
            # find minimum distance vertex from source
            # initially src itself as distance_from_source[src] = 0
            u = self.min_source_visited(distance_from_source, visited_node)
            # mark the node as visited_node
            visited_node[u] = True
            # check if the distance through current edge is less than previously known distance to v
            for v, weight in self.graph[u]:
                # iterate through vertex and weight in the graph
                if visited_node[v] is False and distance_from_source[u] + weight < distance_from_source[v]:
                    # if the node has not been visited and the distance from U is minimum
                    # then set distance of source to V as distance from source to U + weight
                    distance_from_source[v] = distance_from_source[u] + weight
                    parent[v] = u
        # return parent list and distance to each node from source
        return parent, distance_from_source

    # function to print the path
    def print_path(self, parent, vertex):
        if parent[vertex] is None:
            return
        self.print_path(parent, parent[vertex])
        print(vertex, end=' ')

    # function to finally output the result
    def print_result(self, distance, parent, source_node):
        print('{}\t{}\t{}'.format('Vertex', 'Distance', 'Path'))
        for i in self.graph.keys():
            if i == source_node:
                continue
            print('{} -> {}\t\t{}\t\t{}'.format(source_node, i, distance[i], source_node), end=' ')
            self.print_path(parent, i)p


# Driver function
if __name__ == '__main__':
    # make an undirected graph
    graph = Graph()
    # Enter the number of vertices you want in your graph
    number_of_nodes = int(input("enter the number of vertices in the graph "))
    # Maximum edges in a graph of n vertices is (n*n-1)/2
    number_of_nodes = (number_of_nodes * (number_of_nodes - 1)) // 2
    # enter data of each vertex and the corresponding edge weight to create a graph
    for i in range(number_of_nodes):
        graph.add_edge(int(input("enter the start vertex")), int(input("enter the end vertex")),
                       int(input("enter the weight of the edge")))
    source_node = int(input("enter the source node"))
    parent, distance = graph.dijkstra(source_node)
    graph.print_path(parent, int(input("enter the vertex")))
    graph.print_result(distance, parent, source_node)

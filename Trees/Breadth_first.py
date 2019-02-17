# Implement breadth first traversal in a graph
from collections import defaultdict, deque
# initialize graph class
class Graph:
    def __init__(self, directed=False):
        self.graph = defaultdict(list)
        self.directed = directed
# function to add edge
    def add_edge(self, source, dest):
        self.graph[source].append(dest)
        if self.directed is False:
            self.graph[dest].append(source)
        else:
            self.graph[dest] = self.graph[dest]
# check visited nodes
# implement using queue due to ease of pushing and popping in a queue
# start from the start vertex and keep a queue of each node that has been visited
# append each visited node in the queue
    def check_visited(self, start_vertex, visited):
        queue = deque([])
        queue.append(start_vertex)
        visited[start_vertex] = True
        while queue:
            vertex = queue.popleft()
            print(vertex, end=' ')
            # traverse vertices adjacent to vertex
            for i in self.graph[vertex]:
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)
        print()
# function to implement BFS
    def bfs(self, start_vertex=None):
        visited = {i: False for i in self.graph}
        # do bfs from the node specified
        if start_vertex is not None:
            self.check_visited(start_vertex, visited)
        # traverse for all the vertices in other components of graph
        for v in self.graph:
            if not visited[v]:
                self.check_visited(v, visited)
# Driver function
if __name__ == '__main__':
    graph = Graph()
    n = int(input("enter number of edges in the graph "))
    for i in range(n):
        graph.add_edge(int(input("enter source")), int(input("enter destination")))
    # call bfs from 2 vertex
    print("Breadth First Traversal:", graph.bfs(int(input("enter start vertex"))))


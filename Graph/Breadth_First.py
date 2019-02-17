# Program to perform breadth first traversal in a graph
from collections import defaultdict, deque
class Graph:
    def __init__(self, directed=False):
        self.graph = defaultdict(list)
        self.directed = directed
# function to add edge
    def add_edge(self, from_source, to_dest):
        self.graph[from_source].append(to_dest)

        if self.directed is False:
            self.graph[to_dest].append(from_source)
        else:
            self.graph[to_dest] = self.graph[to_dest]
# function to check if a vertex x has been visited or not
    def check_visited(self, x, visited):
        queue = deque([])
        queue.append(x)
        visited[x] = True
        while queue:
            vertex = queue.popleft()
            print(vertex, end=' ')
            # traverse vertices adjacent to vertex
            for i in self.graph[vertex]:
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)
        print()
# function to make a breadth first search
    def bfs(self, s=None):
        visited = {i: False for i in self.graph}
        # do bfs from the node specified
        if s is not None:
            self.check_visited(s, visited)
        # traverse for all the vertices in other graph
        for v in self.graph:
            if not visited[v]:
                self.check_visited(v, visited)
# driver function
if __name__ == '__main__':
    graph = Graph()
    # graph 1
    x = int(input("enter number of vertices in first graph "))
    for i in range(x):
        graph.add_edge(int(input("enter from source "), int(input("enter to destination "))))
    # call bfs from some vertex
    print("Breadth First Traversal:", graph.bfs(int(input("enter vertex to start bfs"))))


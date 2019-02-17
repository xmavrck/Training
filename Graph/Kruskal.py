# Kruskal’s Minimum Spanning Tree
class Graph:
    def __init__(self, directed=False):
        self.edges = []
        self.vertices = set({})
        self.directed = directed

# function to add edge in the graph from_Source to_destination of a given weight
# append wedges and add vertices from_source and to_dest
    def add_edge(self, from_source, to_dest, weight):
        self.edges.append([from_source, to_dest, weight])
        self.vertices.add(from_source)
        self.vertices.add(to_dest)

# function to remove edge from_source to_destination
# initialize two flags: rem_source and rem_dest
# f t w initialize the from,to, weight in the graph
    def remove_edge(self, from_source, to_dest, weight):
        self.edges.remove([from_source, to_dest, weight])
        rem_source = 0
        rem_dest = 0
        for f, t, w in self.edges:
            if from_source == f or from_source == t:
                rem_source = 1
            if to_dest == f or to_dest == t:
                rem_dest = 1
            if rem_source == 1 and rem_dest == 1:
                break

        if rem_source != 1:
            self.vertices.remove(from_source)

        if rem_dest != 1:
            self.vertices.remove(to_dest)

# function to find the set of a vertex in the graph
    def findParent(self, sets, v):
        if sets[v] == -1:
            return v
        else:
            return self.findParent(sets, sets[v])
# function to combine 2 sets x and y
# combine smaller ranked tree under root of higher ranked tree
    def combine(self, sets, x, y):
        x_set = self.findParent(sets, x)
        y_set = self.findParent(sets, y)
        sets[x_set] = y_set
# function to check for cyclicity in the graph
    def check_cycle(self):
        # sets that show combined vertices or not
        sets = {i: -1 for i in self.vertices}
        for v1, v2, w in self.edges:
            # find parents of both vertices of the edge
            x = self.findParent(sets, v1)
            y = self.findParent(sets, v2)
            # if they share a common parent loop found
            if x == y:
                return True
            # union the two vertices in the same set
            self.combine(sets, x, y)
        # if no loop or cycle found return false
        return False
# function for kruskal's algo
    def kruskal(self):
        g = Graph()
        self.edges = sorted(self.edges, key=lambda x: x[2])
        for frm, to, w in self.edges:
            if len(g.edges) == len(graph.vertices) - 1:
                break
            g.add_edge(frm, to, w)
            if g.check_cycle():
                g.remove_edge(frm, to, w)
        return g

# driver function
if __name__ == '__main__':
    # make an undirected graph
    graph = Graph()
    n = int(input("enter nunmber of edges in the graph"))
    for i in range(n):
        graph.add_edge(int(input("enter source"), int(input("enter destination"), int(input("enter weight")))))
    mst = graph.kruskal()
    for f, t, w in mst.edges:
        print(f, "--", t, "=", w)

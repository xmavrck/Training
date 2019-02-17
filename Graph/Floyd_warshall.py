# Find shortest distances between every pair of vertices in a given edge weighted directed Graph
def floyd_warshall(graph):
    distance_matrix = []
    # for storing resultant shortest distances
    for i in graph:  # type: float
        distance_matrix.append(i)
    # Number of vertices in graph

    V = len(graph) - 1
    # k is an intermediate vertex
    for k in range(V + 1):
        # i is the source
        for i in range(V + 1):
            # j is the destination
            for j in range(V + 1):
                # store the path which is shorter: min(i->j, i->k->j)
                if distance_matrix[i][k] == math.inf or distance_matrix[k][j] == math.inf:
                    pass
                else :
                    distance_matrix[i][j] = min((distance_matrix[i][j]), float(distance_matrix[i][k]) + float(distance_matrix[k][j]))
    # return the resultant matrix
    return distance_matrix


import math

if __name__ == '__main__':
    infinity = math.inf
    first_row = list(map(lambda x: infinity if x == 'inf' else float, input("enter the first row").split(" ")))
    second_row = list(map(lambda x: infinity if x == 'inf' else float, input("enter second row ").split(" ")))
    third_row = list(map(lambda x: infinity if x == 'inf' else float, input("enter third row ").split(" ")))
    fourth_row = list(map(lambda x: infinity if x == 'inf' else float, input("enter the fourth row ").split(" ")))
    adjacency_matrix = [first_row,
             second_row,
             third_row,
             fourth_row]
    # get the distance matrix by passing the graph as input to the floyd warshall function
    distance_matrix = floyd_warshall(adjacency_matrix)
    # print the result
    for i in distance_matrix:
        for j in i:
            if j != float('inf'):
                print(j, '\t', end='')
            else:
                print(j, end=' ')
        print()

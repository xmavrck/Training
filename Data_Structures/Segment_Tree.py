import math
# Defines Segment Tree and takes in the input in form of an array
class SegmentTree:
    def __init__(self, input_sequence):
        self.sequence = input_sequence
        self.length = len(input_sequence)
        self.tree = [-1] * (2 ** math.ceil(math.log2(self.length) + 1))
        # The maximum length of a segment tree is next power of 2
        # for e.g. if total length of input_sequence is 5, then the max_length of segment tree is 2^3 = 8
        self.create_tree(0, self.length - 1, 0)

    def create_tree(self, start, end, node):
        if start == end:
            self.tree[node] = self.sequence[start]
            # Leaf node will contain single element
            return

        mid = (start + end) // 2
        self.create_tree(start, mid, 2 * node + 1)
        # Recurse on the left sub tree
        self.create_tree(mid + 1, end, 2 * node + 2)
        # Recurse on the right sub tree
        self.tree[node] = min(self.tree[2 * node + 1], self.tree[2 * node + 2])
        # Internal node stores the minimum of left and right subchild
        return

    def find_min(self, start, end, query_start_index, query_end_index, node):
        # Function to find minimum of the sub array defined from start query index and end query index
        if query_end_index < start or query_start_index > end:
            return None
        # The sub array is out of bound and cannot facilitate searching for minimum element
        if start == query_start_index and end == query_end_index:
            return self.tree[node]
        # Range presented by the given query encompasses the entire array and
        # Return the value of the node which is the minimum of all the elements in the range represented by the node

        mid = (start + end) // 2
        if query_end_index <= mid:
            return self.find_min(start, mid, query_start_index, query_end_index, 2 * node + 1)
        if query_start_index > mid:
            return self.find_min(mid + 1, end, query_start_index, query_end_index, 2 * node + 2)
        # Range represented by a node is partially inside and partially outside the input_sequence
        # Return the minimum of the left child and the right child.
        left_res = self.find_min(start, mid, query_start_index, mid, 2 * node + 1)
        right_res = self.find_min(mid + 1, end, mid + 1, query_end_index, 2 * node + 2)
        return min(left_res, right_res)
        # Helper function that returns minimum of the above query

    def minimum(self, query_start_index, query_end_index):
        return self.find_min(0, self.length - 1, query_start_index, query_end_index, 0)

    def update(self, update_index, update_value, start, end, node):
        # Similar to the minimum functio described above
        if start == end:
            self.tree[node] = update_value
            return
        mid = (start + end) // 2
        if update_index <= mid:
            self.update(update_index, update_value, start, mid, 2 * node + 1)
        if update_index > mid:
            self.update(update_index, update_value, mid + 1, end, 2 * node + 2)

        self.tree[node] = min(self.tree[2 * node + 1], self.tree[2 * node + 2])
        return

# Driver Program for the Segment_Tree
# Input format
# enter the number of elements in the input_sequence and the number of queries to perform on it
# enter space separated input_sequence
# pass the input_sequence to the segment tree class

if __name__ == '__main__':
    n, q = map(int, input().strip().split())
    input_sequence = list(map(int, input().strip().split()))
    seg_tree = SegmentTree(input_sequence)
    for i in range(q):
        query_type, start_left, start_right = input().strip().split()
        if query_type == 'min':
            print(seg_tree.minimum(int(start_left) - 1, int(start_right) - 1))
        elif query_type == 'update':
            seg_tree.update(int(start_left) - 1, int(start_right), 0, n - 1, 0)
        elif query_type == 'tree':
            print(seg_tree)

import math
class MaxHeap:
    def __init__(self, input_sequence=None):
        self.heap = []
        self.heap_size = 0
        if input_sequence is not None:
            self.create_max_heap(input_sequence)
            self.heap = input_sequence
            self.heap_size = len(input_sequence)

    def create_max_heap(self, input_sequence):
        # Converts a given input_sequence into a max heap
        n = len(input_sequence)
        # Last n/2 elements will be leaf nodes (CBT property)
        # Loop from n/2 to 0 index, convert each index node into max heap
        for i in range(int(n / 2), -1, -1):
            self.max_heapify(i, input_sequence, n)

    def max_heapify(self, index, input_sequence, size):
        # convert tree rooted at current index into a max heap.
        # index: Index to check for max heap
        # Get index of left and right child of index node
        left_child = 2 * index + 1
        right_child = 2 * index + 2
        largest = index
        # check what is the largest value node in index, left child and right child
        if left_child < size:
            if input_sequence[left_child] > input_sequence[largest]:
                largest = left_child
        if right_child < size:
            if input_sequence[right_child] > input_sequence[largest]:
                largest = right_child

        # if index node is not the largest value, swap with the largest child
        # and recursively call min_heapify on the respective child swapped with
        if largest != index:
            input_sequence[index], input_sequence[largest] = input_sequence[largest], input_sequence[index]
            self.max_heapify(largest, input_sequence, size)

    def insert(self, value):
        # Inserts an element in the max heap
        self.heap.append(value)
        self.heap_size += 1
        index = self.heap_size - 1
        # Get parent index of the current node

        parent = int(math.ceil(index / 2 - 1))
        # Check if the value of parent is smaller than the newly inserted value
        # if so, then replace the inserted value with the parent value and check with the new parent
        while parent >= 0 and self.heap[index] > self.heap[parent]:
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = int(math.ceil(index / 2 - 1))

    def delete(self, index):
        if self.heap_size == 0:
            print("Heap Underflow!!")
            return

        self.heap[-1], self.heap[index] = self.heap[index], self.heap[-1]
        self.heap_size -= 1
        self.max_heapify(index, self.heap, self.heap_size)

        return self.heap.pop()

    def extract_max(self):
        return self.delete(0)

    def print_max(self):
        print(self.heap)

class MinHeap:
    def __init__(self, input_sequence=None):
        self.heap = []
        self.heap_size = 0
        if input_sequence is not None:
            self.create_min_heap(input_sequence)
            self.heap = input_sequence
            self.heap_size = len(input_sequence)

    def create_min_heap(self, input_sequence):
        # Converts a given input_sequence into a min heap
        n = len(input_sequence)
        for i in range(int(n / 2), -1, -1):
            self.min_heapify(i, input_sequence, n)

    def min_heapify(self, index, input_sequence, size):
        left_child = index * 2 + 1
        right_child = index * 2 + 2
        smallest = index

        if left_child < size:
            if input_sequence[left_child] < input_sequence[smallest]:
                smallest = left_child
        if right_child < size:
            if input_sequence[right_child] < input_sequence[smallest]:
                smallest = right_child

        # if index node is not the smallest value, swap with the smallest child
        # and recursively call min_heapify on the respective child swapped with
        if smallest != index:
            input_sequence[index], input_sequence[smallest] = input_sequence[smallest], input_sequence[index]
            self.min_heapify(smallest, input_sequence, size)

    def insert(self, value):
        self.heap.append(value)
        self.heap_size += 1

        index = self.heap_size - 1
        parent = int(math.ceil(index / 2 - 1))

        # Check if the parent value is smaller than the newly inserted value
        # if so, then replace the value with the parent value and check with the new parent
        while parent >= 0 and self.heap[index] < self.heap[parent]:
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = int(math.ceil(index / 2 - 1))

    def delete(self, index):
        if self.heap_size == 0:
            print("Heap Underflow!!")
            return

        self.heap[-1], self.heap[index] = self.heap[index], self.heap[-1]
        self.heap_size -= 1
        self.min_heapify(index, self.heap, self.heap_size)
        return self.heap.pop()

    def extract_min(self):
        return self.delete(0)

    def print_min(self):
        print(self.heap)

if __name__ == '__main__':
    input_sequence = list(map(int, input("enter a list of numbers ").split(",")))
    query = input("enter MIN to get min heap and MAX to get max heap ")
    if query == 'MIN':
        heap = MinHeap(input_sequence)
        heap.insert(int(input("enter any element to insert ")))
        print(heap.delete(int(input("enter index of element to be deleted "))))
        print(heap.extract_min())
        heap.print_min()
    elif query == 'MAX':
        heap = MaxHeap(input_sequence)
        heap.insert(int(input("insert a element ")))
        print (heap.delete(int(input("enter index of element to delete from the list "))))
        print(heap.extract_max())
        heap.print_max()

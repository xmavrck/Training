def update(index, value, array, fenwick_tree):
    while index < len(array):
        fenwick_tree[index] += value
        index += index & -index
# function to calculate sum of elements from beginning to the index in the binary index tree
# return sum of elements from beginning till index
def get_sum(index, fenwick_tree):
    ans = 0
    while index > 0:
        ans += fenwick_tree[index]
        index -= index & -index
    return ans
# function to calculate sum from given range
# left to get the left index of the range and right to get the right index
def get_range_sum(left, right, fenwick_tree):
    ans = get_sum(right, fenwick_tree) - get_sum(left - 1, fenwick_tree)
    return ans
# driver function
if __name__ == '__main__':
    n = int(input('Enter the number of elements: '))
    input_sequence = [int(x) for x in input('Enter the {} elements of the array: '.format(n)).split()]
    input_sequence.insert(0, 0)
    # insert dummy node for 1-based indexing
    fenwick_tree = [0 for i in range(n + 1)]
    query = input("Enter update for updating the tree, range for range sum queries")
    if query == 'update':
        for index in range(1, n + 1):
            update(index, input_sequence[index], input_sequence, fenwick_tree)
    elif query == 'range':
            l, r = map(int, input('Enter the left and right indices for the range sum: ').split())
            print(get_range_sum(l, r, fenwick_tree))

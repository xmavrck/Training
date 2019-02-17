# implement knapsack
def knapSack(capacity, weight, value, size):
    # First row is the case where no items are chosen.
    # Skip it
    # capacity + 1 to counter 0 - capacity choices, same for size
    best_value = [[0 for i in range(capacity + 1)] for i in range(size + 1)]
    # iterate through items
    for size in range(size + 1):
        for capacity in range(capacity + 1):
            # when weight of current item is greater than knapsack capacity we cant add it
            # best sum of values for any sub sequence of the first i items
            # whose combined weight is less than knapsack capacity
            if size == 0 or capacity == 0:
                best_value[size][capacity] = 0
            elif weight[size - 1] <= capacity:
                best_value[size][capacity] = max(value[size - 1] + best_value[size - 1][capacity - weight[size - 1]], best_value[size - 1][capacity])
            else:
                best_value[size][capacity] = best_value[size - 1][capacity]
    for capacity in best_value:
        print(capacity)
    return best_value
# function to collect elements from the sack
def elements_collected_from_sack(capacity, matrix, weight, value, size):
     i = size
     row = capacity
     list_of_elements = []
     while i > 0:
         if matrix[i][row] - matrix[i-1][row - weight[i - 1]] == value[i - 1]:
             list_of_elements.append(value[i - 1])
             i -= 1
             row -= weight[i - 1]
         else:
             i -= 1
     return list_of_elements
# Driver function
if __name__ == '__main__':
    price = list(map(int, input("enter the prices of items ").split(" ")))
    weight = list(map(int, input("enter the weight of the items ").split(" ")))
    capacity = int(input("enter knapsack capacity "))
    n = len(price)
    best_value = knapSack(capacity, weight, price, n)
    print(best_value[n][capacity])
    print(elements_collected_from_sack(capacity, best_value, weight, price, n), end=' ')

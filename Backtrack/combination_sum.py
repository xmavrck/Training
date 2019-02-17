# Implement combination sum
# Function returns result list
def combination_sum(input_sequence, target_sum):
    # Initialize an empty list to contain the intermediate values that add up to the sum
    result = []
    # Sort the intermediate values
    input_sequence.sort()
    # Call the dfs function that takes in 5 arguments, the inputs, the target sum, start index = 0, an empty list that
    # stores the path of the depth first traversal, result that contains the output list.
    dfs(input_sequence, target_sum, 0, [], result)
    return result
# The Dfs function computes the sum of each element in the input sequence.
# Whenever each sum equals the target sum it stores the path and appends the path

def dfs(intermediates, target_sum, index, path, result):
    if target_sum == 0:
        result.append(path)
        return
    for i in range(index, len(intermediates)):
        next = target_sum - intermediates[i]
        if next < 0:
            return
        dfs(intermediates, next, i, path + [intermediates[i]], result)

# Driver function
if __name__ == '__main__':
    input_sequence = list(map(int, input(" enter the list of numbers ").split(" ")))
    target_sum = int(input("enter the target sum"))
    print (combination_sum(input_sequence, target_sum), end = " ")

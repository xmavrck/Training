# implement radix sort
def flatten(input_list):
    # Flatten a list of lists.|
    # [elements of list a, elements of list b, etc]
    new_list = []
    for sub_list in input_list:
        new_list += sub_list
    return new_list
# function radix
def radix(input_list, index=None, size=None):
    # Initialize variables not set in the initial call
    if size == None:
        largest_num = max(input_list)
        largest_num_str = str(largest_num)
        largest_num_len = len(largest_num_str)
        size = largest_num_len
    if index == None:
        index = size
    # the index we're looking at in a number
    # the 10's place for 100 of size 3 will have index = 2 so i will be (3-2) = 1
    i = size - index
    # The recursive base case.
    if i >= size:
        return input_list
    # Initialize the place_numbers
    place_numbers = [[] for _ in range(10)]
    # Iterate over the list of numbers we are given
    for x in input_list:
        #   size: 5 x: 29 num_s: '00029'
        num_s = str(x).zfill(size)
        place_c = num_s[i]
        place_i = int(place_c)
        place_numbers[place_i] += [x]
    result = []
    for b in place_numbers:
        # Make the recursive call
        # Sort each of the sub-lists in our place_numbers
        result.append(radix(b, index - 1, size))
    # Flatten list.
    flattened_result = flatten(result)
    return flattened_result

# driver function
if __name__ == '__main__':
    input_list =list(map(int, input("enter a list of numbers ").split(" ")))
    size = int(input("enter the max size to sort "))
    index = int(input("Enter index to look at "))
    print("Sorted list ", radix(input_list, index, size))

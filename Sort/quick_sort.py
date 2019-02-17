# Implement Quick Sort
def quicksort(input_sequence):
    # If there are less than or 1 element in the list return the list as is
    if len(input_sequence) <= 1:
        return input_sequence
    # Else fix pivot as the mid position
    pivot = input_sequence[len(input_sequence) // 2]
    # Sort elements to the left of pivot value if their value is less than pivot_value using list
    left = [x for x in input_sequence if x < pivot]
    # While middle is the pivot
    middle = [x for x in input_sequence if x == pivot]
    # Sort elements to the right of pivot if their value is greater than pivot_value
    right = [x for x in input_sequence if x > pivot]
    # Recursively return the values of the left sub list and middle and the right sublist
    # Divide and Conquer
    return quicksort(left) + middle + quicksort(right)


# Driver Function
if __name__ == '__main__':
    input_sequence = list(input("enter an unsorted list").split(" "))
    print('Sorted List:', quicksort(input_sequence))

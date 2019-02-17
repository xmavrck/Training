
def insertionSort(input_sequence):
    for current_index in range(1, len(input_sequence)):
        # Iterate over the unsorted list with the iterator being the current_index and the iterable being the input_sequence
        # iterate until the length of the input sequence is reached
        current_number = input_sequence[current_index]
        # let current_number be the current index of the input sequence
        for j in range(current_index - 1, -1, -1):
            # iterate from the current index - 1 to the end of the sequence
            # if a value is found to be grater than the current_number perform a swap operation
            # store the value of the current number in the sorted sequence
            if input_sequence[j] > current_number:
                input_sequence[j], input_sequence[j + 1] = input_sequence[j + 1], input_sequence[j]
            else:
                # else store the value of the current number in the next index of the sorted sequence
                input_sequence[j + 1] = current_number
                break
    return input_sequence


if __name__ == '__main__':
    input_sequence = list(map(int, input("enter a list of unsorted numbers").split(" ")))
    print('Sorted List:', insertionSort(input_sequence))

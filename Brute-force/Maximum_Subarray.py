# implement maximum sab array
def max_subarray(input_sequence, size):
    current_max = input_sequence[0]
    max_yet = input_sequence[0]
    for i in range(1, size):
        current_max = max(input_sequence[i], current_max + input_sequence[i])
        max_yet = max(current_max, max_yet)
    return max_yet

# driver function
if __name__ == '__main__':
    test_case = int(input("enter number of test cases"))
    for t in range(test_case):
        n = int(input("enter size"))
        input_sequence = list(map(int, input("enter the sequence").split()))
        temp_sequence = list(filter(lambda x: x > 0, input_sequence))
        if len(temp_sequence) != 0:
            max_sum = sum(temp_sequence)
        else:
            max_sum = max(input_sequence)
        print(max_subarray(input_sequence, n), max_sum)

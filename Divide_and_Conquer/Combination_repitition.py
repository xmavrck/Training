
# Function combination takes in input sequence and the size of combination
def combination(input_sequence, combination_size):
    length_of_input = len(input_sequence)
    temp_sequence = [0] * combination_size
    divideconquer(input_sequence, temp_sequence, 0, length_of_input - 1, 0, combination_size)


# divide nd conquer function takes in 5 arguments and is called recursively to generate
# tree like structure for each iterable in the input sequence
def divideconquer(input_sequence, temp_sequence, start, end, index, combination_size):
    if (index == combination_size):
        for j in range(combination_size):
            print(temp_sequence[j])
        print()
        return
    else:
        i = start
        while (i <= end):
            temp_sequence[index] = input_sequence[i]
            # Divide and conquer starts from the current node irrespective of whether it has been selected or not
            # It doesn't start from i+1
            divideconquer(input_sequence, temp_sequence, i, end, index + 1, combination_size)
            i += 1


if __name__ == '__main__':
    input_sequence = input("enter the input sequence ").split(" ")
    combination_size = int(input("enter the size of combination "))
    combination(input_sequence, combination_size)

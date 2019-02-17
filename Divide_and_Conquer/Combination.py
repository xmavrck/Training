
import re  # to enable splitting for any type space
# Function combination takes in input sequence and the size of combination
def combination(input_sequence, combination_size):
    length_of_input = len(input_sequence)
    temp_sequence = [0]*combination_size
    divideconquer(input_sequence,temp_sequence,0,length_of_input-1,0,combination_size)


# divideandconquer function takes in 5 arguments and is called recursively to generate
# tree like structure for each iterable in the input sequence

def divideconquer(input_sequence, temp_sequence, start, end, index, combination_size):
    # check if the index on recursion reaches the size of combination and if it does our combination is ready to be printed
    # else start at the start index and recuresively navigate to the end of the input sequence
    #end-i+1 >= index ensures that atleast one combination is made for the last remaining element.
    if (index == combination_size):
        for j in range(combination_size):
            print(temp_sequence[j])
        print()
        return
    else:
        i = start
        while(i <= end and end - i + 1 >= combination_size - index):
            temp_sequence[index] = input_sequence[i]
            divideconquer(input_sequence, temp_sequence, i + 1, end, index + 1, combination_size)
            i+=1
# driver function
if __name__ == '__main__':

    input_sequence = re.split(r'[;,\s]\s*', input("enter a list "))
    combination_size = int(input("enter the size of combination "))
    combination(input_sequence, combination_size)

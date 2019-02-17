# Implement interpolation search
def interpolation_search(input_sequence, key):
    start = 0
    end = len(input_sequence) - 1
    while input_sequence[end] != input_sequence[start] and key >= input_sequence[start] and key <= input_sequence[end]:
        mid = int(
            start + ((key - input_sequence[start]) * (end - start) / (input_sequence[end] - input_sequence[start])))
        if input_sequence[mid] == key:
            return mid
        elif input_sequence[mid] < key:
            start = mid + 1
        else:
            end = mid - 1
    return -1
# Driver function
if __name__ == '__main__':
    input_sequence = list(map(int, input("enter input ").split(" ")))
    key = int(input("Enter a key "))
    print (interpolation_search(input_sequence, key))

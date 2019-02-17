# Implement binary search
def binary_search(input_sequence, x):
    global mid
    l = 0
    r = len(input_sequence)
    # while the left index marker < right index marker
    while l < r:
        # find the index of the middle element
        mid = int(l + ((r - l) / 2))
        # if middle element is x, return mid
        if input_sequence[mid] == x:
            return mid
        # if middle element is < x, update l to search to the right of mid
        elif input_sequence[mid] < x:
            l = mid + 1
        # if middle element is > x, update r to search to the left of mid
        else:
            r = mid - 1
    return mid
# Driver function
if __name__ == '__main__':
    input_sequence = list(map(int, input("Enter an array of numbers ").split(" ")))
    x = int(input("enter element to find "))
    index = binary_search(input_sequence, x) + 1
    print("element found at index ", index)
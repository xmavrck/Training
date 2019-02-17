# implement rain terraces
def tap_water(input_sequence, length):
    # initial water that is trapped
    tapped = 0
    # max bar length on left and right
    left_bound = 0
    right_bound = 0
    # indices to traverse the array
    left = 0
    right = length - 1
    while (left <= right):
        if (input_sequence[left] < input_sequence[right]):
            if (input_sequence[left] > left_bound):
                # update left bound
                left_bound = input_sequence[left]
            else:
                # water tapped currently  = max - current
                tapped += left_bound - input_sequence[left]
            left += 1
        else:
            if (input_sequence[right] > right_bound):
                # update right maximum
                right_bound = input_sequence[right]
            else:
                tapped += right_bound - input_sequence[right]
            right -= 1
    return tapped
# driver function
if __name__ == '__main__':
    input_sequence = list(map(int, input("Enter the bar length ")))
    length = len(input_sequence)
    print("Maximum water that can be accumulated is ", tap_water(input_sequence, length))

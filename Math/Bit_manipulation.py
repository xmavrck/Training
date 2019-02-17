# Count number of bits needed to be flipped to convert A to B
# Query = CB
def count_bits_flip(a, b):
    # XOR a and b to get 1 on opposite value bit position
    c = a ^ b
    # initialise the counter for 1
    count = 0
    # count the number of 1s while there is 1 in a ^ b
    while c != 0:
        count += 1
        c &= (c - 1)
    # return the count of 1s
    return count
# Check whether a given number n is a power of 2 or 0
# Query = CP
def check_pow_2(num):
    if num == 0:
        print("number is a power of 2")
        return
    elif num & (num - 1) == 0:
        print("number is a power of 2")
    else: print("number is not a power of 2")
    return
# Query = GB
def get_bit(value, position):
    return ((value >> position & 1) != 0)
# Query = SB
def set_bit(value, position):
    return value | (1 << position)
# Query = Clear
def clear_bit(value, position):
    return value & ~(1 << position)
# Query = NRM
def find_non_repeating_numbers(input_sequence):
    xor = input_sequence[0]
    for i in range(1, len(input_sequence)):
        xor ^= input_sequence[i]
    right_set_bit = xor & ~(xor - 1)
    first = 0
    second = 0
    for i in input_sequence:
        if i & right_set_bit:
            first ^= i
        else:
            second ^= i
    return first, second

if __name__ == '__main__':
    query =input("enter CB/CP/NRM/GB/SB/Clear: ")

    if query == 'CB':
        a = int(input("enter number 1 "))
        b = int(input("enter number 2 "))
        print(count_bits_flip(a,b))

    elif query == 'CP':
        num = int(input("enter a number"))
        print(check_pow_2(num))

    elif query == 'NRM':
        input_sequence = list(map(int, input("Enter a list of numbers:").split(",")))
        print(find_non_repeating_numbers(input_sequence))

    elif query == 'GB':
        value = int(input("enter a value to get bit: "))
        position = int(input("enter the number of bits to get "))
        print("value after bit get operation", get_bit(value, position))

    elif query == 'SB':
        value = int(input("enter a value to set bits to : "))
        position = int(input("enter the number of bits to set "))
        print("value after bit set operation ", set_bit(value, position))

    elif query == 'Clear':
        value = int(input("enter a value to clear bits of : "))
        position = int(input("enter the number of bits to clear "))
        print("value after bit clear operation ", clear_bit(value, position))
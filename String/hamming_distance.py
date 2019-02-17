# The Hamming distance is defined between two strings of equal length
# It measures the number of positions with mismatching characters
# implement hamming distance
def hamming_distance(string_1, string_2):
    assert len(string_1) == len(string_2)
    return sum(ch1 != ch2 for ch1, ch2 in zip(string_1, string_2))
# driver function
if __name__ == "__main__":
    string_1 = input("enter string 1")
    string_2 = input("enter string 2")
    print(hamming_distance(string_1, string_2))
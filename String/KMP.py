# implement KMP
# function to implement KMP_Search
# returns list of indexes where the pattern matches
def KMP(pattern, text):
    length_of_text = len(text)
    length_of_pattern = len(pattern)
    # pre compute prefix array of the pattern
    prefix_arr = prefix_sequence(pattern, length_of_pattern)
    # stores start point of pattern match in text
    start_points = []
    i = 0
    j = 0
    # while the whole text has not been searched
    while i != length_of_text:
        # if the character in text matches the pattern character
        if text[i] == pattern[j]:
            i += 1
            j += 1
        # else find the previous index from where the matching can resume
        else:
            j = prefix_arr[j-1]

        # if pattern length has been reached that means a pattern has been found
        if j == length_of_pattern:
            start_points.append(i-j)
            j = prefix_arr[j-1]
        elif j == 0:
            i += 1
    # return the starting position of pattern in text
    return start_points

# pre-computes the prefix sequence for KMP search
def prefix_sequence(pattern, length_of_text):
    prefix_seq = [0] * length_of_text
    j = 0
    i = 1
    while i != length_of_text:
        if pattern[i] == pattern[j]:
            j += 1
            prefix_seq[i] = j
            i += 1
        elif j != 0:
                j = prefix_seq[j-1]
        else:
            prefix_seq[i] = 0
            i += 1
    return prefix_seq

# driver function
if __name__ == '__main__':
    text = input("enter the text to search ")
    pattern = input("Enter the pattern to be searched ")
    start_indexes = KMP(pattern, text)
    for i in start_indexes:
        print(i)

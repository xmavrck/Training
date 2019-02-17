# Implement longest common subsequence
def longest_common_subsequence(string_1, string_2):
    # Assuming string_2 has all unique chars
    # enumerate function counts the number of times a certain character appears in string2
    dict_string2 = {c: i for i, c in enumerate(string_2)}
    max_length = 0
    # to store a list of subsequence that appears in both the strings
    subsequence_list = ''
    # iterator for string 1
    i = 0
    while i < len(string_1):
        # check if character occuring at ith index in string 1 is present in dictionary of string2
        if string_1[i] in dict_string2:
            j = dict_string2[string_1[i]]
            # if so then assign that to a variable k
            k = i
            while j < len(string_2) and k < len(string_1) and string_1[k] == string_2[j]:
                k += 1
                j += 1
            if k - i > max_length:
                max_length = k - i
                subsequence_list = string_1[i:k]
            i = k
        else:
            i += 1
    return subsequence_list
# Driver function
if __name__ == '__main__':
    s1 = input("enter string 1 ")
    s2 = input("enter string 2 ")
    print(longest_common_subsequence(s1, s2))
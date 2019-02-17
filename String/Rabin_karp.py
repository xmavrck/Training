# implement rabin karp
class hash:
    def __init__(self, input_sequence, word_size):
        self.text = input_sequence
        self.hash = 0
        self.wordsize = word_size

        for i in range(0, word_size):
            # ord maps the value of input character to output ascii value
            # subtract out the ASCII value of "a" to start the indexing at zero
            self.hash += (ord(self.text[i]) - ord("a") + 1) * (26 ** (word_size - i - 1))

        # start index of current window
        self.window_start = 0
        # end of index window
        self.window_end = word_size
# function to implement window that slides on each word
    def word_window(self):
        # Function to slide a window of text from start index by incrementing one
        if self.window_end <= len(self.text) - 1:
            # remove left letter from hash value
            self.hash -= (ord(self.text[self.window_start]) - ord("a") + 1) * 26 ** (self.wordsize - 1)
            # add the rolling hash H(bcd) = H(abc-a) * 26 + H(d)
            self.hash *= 26
            self.hash += ord(self.text[self.window_end]) - ord("a") + 1
            self.window_start += 1
            self.window_end += 1
# function to implement window that slides on each word of the text
    def text_window(self):
        # returns the text of current window that is being matched by the Sliding window
        return self.text[self.window_start:self.window_end]
# function to implement rabin karp
def rabin_karp(word_to_find, text_to_search):
    # pretty self explanatory
    if word_to_find == "" or text_to_search == "":
        return None
    # else if the length of the word exceeds the limit of text return None
    if len(word_to_find) > len(text_to_search):
        return None
    # calls the rolling hash class and passes the text to search from and the length of the word window
    rolling_hash = hash(text_to_search, len(word_to_find))
    # computes the word hash of the sliding window
    word_hash = hash(word_to_find, len(word_to_find))
    # word_hash.move_window()
    for i in range(len(text_to_search) - len(word_to_find) + 1):
        if rolling_hash.hash == word_hash.hash:
            if rolling_hash.text_window() == word_to_find:
                print ("word", word_to_find, "found at index", i, "extending upto", i + len(word_to_find))
                print ("subtext : ", text_to_search[i:len(word_to_find) + 10])
        rolling_hash.word_window()
    return None

# Driver function accepts the word to find in a text
if __name__ == '__main__':
    word_to_find = input(" Enter the word to find ")
    text_to_search = input(" Enter text to find the word in ")
    rabin_karp(word_to_find, text_to_search)

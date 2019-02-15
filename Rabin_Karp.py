class RollingHash:
    def __init__(self, input_text, word_size):
        self.text = input_text
        self.hash = 0
        self.size = word_size

        for i in range (0,  word_size):

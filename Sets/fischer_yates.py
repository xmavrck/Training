from random import randint, random
from math import floor
# implement fischer yates
def fisher_yates_shuffle(input_list):
    to_shuffle = len(input_list)
    while to_shuffle > 1:
        # Index must be an integer not a float and floor returns a float
        i = int(floor(random() * to_shuffle))
        # using the back of the list to store the already shuffled index,
        # subtract by one to make sure no overwrite/move occurs
        to_shuffle -= 1
        # Move item from i to the front-of-the-back-of-the-list. (Catching on?)
        input_list[i], input_list[to_shuffle] = input_list[to_shuffle], input_list[i]
    return input_list
# driver function
if __name__ == '__main__':
    input_list = list(map(str, input("enter a list ").split(" ")))
    print("shuffled ", fisher_yates_shuffle(input_list))

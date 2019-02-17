# implement a hash table
class Hash_Table(object):
    def __init__(self):
        # initialize the hash table as none for some limit
        self.hash_table = [[(None, None)] for i in range(1000)]
# function to insert values into the hashtable as per the key-value pairing
    def insert(self, key, value):
        # compute hash key by modulo division with the length of the hash table
        hash_key = hash(key) % len(self.hash_table)
        current_key = 0
        hash_list = self.hash_table[hash_key]
        # print(key, value)
        for i, key_value_pair in enumerate(hash_list):
            # check for key value pairing
            key_in_table, value_in_table = key_value_pair
            # if a key exists in the table then update the value of current_key
            if key == key_in_table or key_in_table == None:
                current_key = 1
            # if a key value pair is assigned to the hash table then update the value
            # else append the key-value pair to the hash_list
            if current_key:
                hash_list[i] = ((key, value))
            else:
                hash_list.append((key, value))
# Retrieve data from the hash table
    def get(self, key):
        # compute the length of the hash key
        hash_key = hash(key) % len(self.hash_table)
        # pass the object of Hash_Table class to the hash_list
        hash_list = self.hash_table[hash_key]
        # search for the key value in the hash_list
        # if a key-value pair is found in the hash_list then return the value
        # else raise an exception: KeyError
        for i, key_value in enumerate(hash_list):
            key_in_table, value_in_table = key_value
            return value_in_table
        raise KeyError
# Driver Function that takes in number of entries you want to store in the hash table
if __name__ == '__main__':
    dictionary = Hash_Table()
    number_of_entries = int(input("enter number of entries"))
    for i in range(number_of_entries):
        dictionary.insert(input("enter key"), input("enter value"))
    value = dictionary.get(input("enter a value to retrieve"))
    print(value)

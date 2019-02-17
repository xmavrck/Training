def linear_search(input_sequence, query_element):
    # define a function linear search that takes in two inputs input_Sequence and the query element
    for i in range(0, len(input_sequence)):
        if input_sequence[i] == query_element:
            print ("element found at ", i)
    else:
        return ("Not found")

if __name__ == '__main__':
    input_sequence = list(input("enter a sequence").split(" "))
    query_element = input("enter a query element")
    linear_search(input_sequence, query_element)

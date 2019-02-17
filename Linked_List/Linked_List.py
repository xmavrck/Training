
# Linked List Reverse Traversal:
# If the linked list contains 0 or 1 node then return the list as is
# If there are more than two nodes then initialize 2 pointers
# Forward pointer initialized to (head.next) in the current list and reverse pointer to head in the already reversed linked list
# Set reverse pointer.next == None, this becomes the last node in the linked list
# forward_pointer iterates until it reaches None. The current node becomes the head of reversed linked list.
# Iteration stops when forward pointer == None and reverse pointer is pointing to new head

class Node:
    # initialise data and next
    def __init__(self, data=None):
        self.data = data
        self.next = None


class LinkedList:
    # initialise head
    def __init__(self):
        self.head = None

    # Function to reverse a linked list
    def reverse(self):

        # If linked list is empty
        if self.head is None:
            return None

        forward_pointer = self.head
        reverse_pointer = None

        while forward_pointer is not None:
            # Store the value of forward_pointer.next
            next = forward_pointer.next
            # Set forward_pointer.next to point to the previous node
            forward_pointer.next = reverse_pointer
            # Update pointers for next iteration
            reverse_pointer = forward_pointer
            forward_pointer = next

        self.head = reverse_pointer

    # Function to Insert data at the beginning of the linked list
    def insert_at_beg(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node

    # Function to print the linked list
    def print_data(self):
        current = self.head
        while current is not None:
            print(current.data, '-> ', end='')
            current = current.next
        print('None')


# Driver function to run the program
if __name__ == '__main__':
    linked_list = LinkedList()
    # linked_list is the object of Class LinkedList
    tot_elements = int(input("total elements = "))
    # Enter the number of elements you want in your linked list
    for i in range(tot_elements):
        linked_list.insert_at_beg(input("enter data at node"))
        linked_list.print_data()
    # Prints the current instance of linked list upon each insertion
    linked_list.reverse()
    # call the reverse function
    linked_list.print_data()
    # Print the reversed linked list

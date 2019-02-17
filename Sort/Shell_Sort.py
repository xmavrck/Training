# implement shell sort
def shellsort(userlist):
    # Function to shell sort a user input list
    SubListCount = len(userlist) // 2
    # Sublists are the division of user input list into requisite gap lengths
    while (SubListCount > 0):
        # Iteration on the sublists until the Sublist_count drops to 1, which is the final insertion sort
        for StartPosition in range(SubListCount):
    # Iterate start position on the sublist and
            Gap_Insertion_Sort(userlist, StartPosition, SubListCount)
        SubListCount = SubListCount // 2
    return userlist


def Gap_Insertion_Sort(userlist, start, gap):
    for i in range(start + gap, len(userlist),
                   gap):  # iterate over the list in spaces of lengths = gap, if gap = 1, it becomes a standard insertion sort
        current_value = userlist[i]  # the first value encountered on iteration at index i is assumed to be the current value
        position = i  # the current position is the index number and we have to iterate the list in the gap fixed initially
        while (position >= gap and userlist[
            position - gap] > current_value):
            # if the value at new index at length start+gap is greater the current value swap them
            userlist[position] = userlist[position - gap]
            position = position - gap
            # Go to next position
        userlist[position] = current_value
        # Store the value at the old index

#Driver program
if __name__ == '__main__':
    userlist = list(map(int,input("enter unsorted list").split(",")))
    print("sorted list: ", shellsort(userlist))  # Print the sorted list

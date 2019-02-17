#implement tower of hanoi
# function to move towers
def move_tower(height, from_pole, to_pole, intermediate_pole):
    if height >= 1:
        move_tower(height - 1, from_pole, intermediate_pole, to_pole)
        move_disk(from_pole, to_pole)
        move_tower(height - 1, intermediate_pole, to_pole, from_pole)

# function to move disks
def move_disk(from_pole, to_pole):
    print("moving disk from", from_pole, "to", to_pole)

# driver function
if __name__ =='__main__':
    move_tower(3, "A", "B", "C")
    print(move_disk(input("enter disk 1"), input("enter disk 2")))
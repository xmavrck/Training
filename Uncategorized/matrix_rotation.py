# implement in place matrix rotation
# define a function that takes in input as array and the index of rotation
import numpy as np
def rotate(input_array, number_of_rotation):
    print ("original array: ", input_array)
    return np.rot90(input_array, number_of_rotation).reshape(m,n)
# Driver Function
if __name__ == '__main__':
    number_of_rotation = input("enter the number of times you want to rotate")
    m = int(input("rows of matrix"))
    n = int(input("columns of matrix"))
    input_array = np.arange(int(input("enter start number")), int(input("enter end number"))).reshape(m,n)
    print("rotated matrix: ", rotate(input_array, number_of_rotation).reshape(m,n))

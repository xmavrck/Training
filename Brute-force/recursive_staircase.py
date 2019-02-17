# implement recursive staircase
def recursive_staircase(n):
    if n == 1 or n == 0:
        return 1
    elif n == 2
        return  2
    else:
        return recursive_staircase(n-3)+recursive_staircase(n-2)+recursive_staircase(n-1)
# driver function
if __name__ == '__main__':
    n = int(input("enter number of stairs"))
    print("no. of solutions", recursive_staircase(n))
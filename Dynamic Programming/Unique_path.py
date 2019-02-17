# implement unique path
import  math
def unique_path(m, n):
        return math.factorial(m+n-2)/math.factorial(m-1)/math.factorial(n-1)
if __name__ == '__main__':
    m,n = int(input("enter m")), int(input("enter n"))
    print("unique paths = ", unique_path(m, n))
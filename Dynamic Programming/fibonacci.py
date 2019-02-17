
#Fibonacci function
def fibonacci(limit):
    fib1,fib2 = 0,1
    count = 0 #fibonacci term count
    while(count<limit): #loop while term count is less than fibonacci limit
        if(limit == 0 or limit == 1): #return 1 when limit is zero or one
            print("series:", fib1)
            exit()
        else:
            count+=1 #Increase the counter
            print("Fibonacci term", count, "is", fib1)
            fib1,fib2 = fib2,fib2+fib1 #Increase the sequence
            exit()
    return (fib2-fib1)
#Driver
if __name__ == "__main__":

    limit = int(input("enter limit"))
    print(fibonacci(limit))

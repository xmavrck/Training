# Implement sieve of eratosthenes
def primes(x):
    assert (x >= 0)
    # Make sure x > 0 so that the function doesnt return any number less than 0
    sieve = [1 for v in range(x + 1)]
    # prepare sieve such that it contains all the numbers less than x
    primes = []
    # Initialize a list of Primes
    for i in range(2, x + 1):
        if sieve[i] == 1:
            primes.append(i)
            for j in range(i, x + 1, i):
                sieve[j] = 0
    return primes


# Driver Function
if __name__ == '__main__':
    x = int(input("enter the number until which you want to find the prime number "))
    print (primes(x))

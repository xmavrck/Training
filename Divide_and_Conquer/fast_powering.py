x = 1000000007
def fast_power(base, power):
    result = 1
    while power > 0:
        # if power is odd
        if power % 2 == 1:
            result = (result * base) % x
        # divide the power by 2
        power = power / 2
        # multiply base to itself
        base = (base * base) % x
    return result
if __name__ == '__main__':
    base = int(input("enter base "))
    power = int(input("Enter the power "))
    print("result ", fast_power(base, power))

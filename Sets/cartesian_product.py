# Implement Cartesian Product
# two input sequences are mapped from one sequence to another
def cartesian_product(sequence1, sequence2):
    return [[x,y]for x in sequence1 for y in sequence2 ]
# Driver function
if __name__ =='__main__':
    sequence1 = list(map(int, input("enter first sequence ").split(" ")))
    sequence2 = list(map(int, input("enter second sequence ").split(" ")))
    print(cartesian_product(sequence1,sequence2))

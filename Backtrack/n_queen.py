# Implement a N-queen solution
def chess_board(board):
    # print chess board if queen can be placed at the position
    for row in board:
        for placed_queen in row:
            print('Q', end=' ') if placed_queen else print('X ', end='')
        print()
    print()

# Check for the safety of the queen
def check_queen_placement(board, row, column):
    if any(board[row]): return False
        # check for every column of the chess board where a queen has not been placed in a row
    
for row_move in range(len(board[0])):
        # if a queen is placed in the board return false
        if board[row_move][column]: return False
    # Check for row column and diagonals to place the queen
    # initialize the row and column to row_move and col_move

    row_move, col_move = row, column
    # Length of the board, if queen is tried to be placed at a position other than this, return false
    length_of_board = len(board)
    # search the upper diagonal
    # if queen is found in any row/column, skip the rows and columns move ahead

    while row_move < length_of_board and col_move < length_of_board:
        if board[row_move][col_move]: return False
        row_move, col_move = row_move + 1, col_move + 1
    # search the rows
    # if queen is found at any column, skip the column go for rows
    row_move, col_move = row, column
    while row_move < length_of_board and col_move >= 0:
        if board[row_move][col_move]: return False
        row_move, col_move = row_move + 1, col_move - 1
    # search the columns
    # if queen is found in column skip the row and move on to next column
    row_move, col_move = row, column
    while row_move >= 0 and col_move < length_of_board:
        if board[row_move][col_move]: return False
        row_move, col_move = row_move - 1, col_move + 1
    # search the lower diagonal
    # if a queen is found in one of the row or column skip search in either
    row_move, col_move = row, column
    while row_move >= 0 and col_move >= 0:
        if board[row_move][col_move]: return False
        row_move, col_move = row_move - 1, col_move - 1
    return True

# Function to place queen
# calculate number of solutions
def place_queen(board, row=0):
    global number_of_solutions
    if row >= len(board):
        chess_board(board)
        number_of_solutions += 1
        return
    for column, placed_queen in enumerate(board):
        if check_queen_placement(board, row, column):
            board[row][column] = True
            place_queen(board, row + 1)
            board[row][column] = False

# Driver function
if __name__ == '__main__':
    number_of_solutions = 0
    n = int(input("enter number of queens "))
    board = [[False] * n for i in range(n)]
    place_queen(board)
    print("Found %s solutions: " % number_of_solutions)

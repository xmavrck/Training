/* This is the program that implements the unique path problem. Here the problem was
A robot is placed at the lowermost corner of the matrix i.e. if the size of the matrix is
4,4 then the robot is placed at matrix[4][4]. Now the robot has to reach to the top most
corner of the matrix i.e. matrix[0][0]. But the restriction is that the robot can only
move in 2 directions -
1- either in left direction
2- or in upward direction
We have to find out the no. of ways or paths to reach the destination.*/

fn main() {

    const M: usize = 4;
    const N: usize = 4;
    let mut grid = [[0 as u8; N] ; M];

    for i in 0..M{
        for j in 0..N{

            if (i==3 || j==3) && (i!=j){

                grid[i][j]=1;
            }
        }
    }

    println!("This is the initial path provided to the matrix: ");

    for (_i, row) in grid.iter_mut().enumerate() {
        for (_y, col) in row.iter_mut().enumerate() {
            print!("{}  ", col);
        }
        println!("");
    }

    println!("This is the final path matrix: ");

    for i in (0..M-1).rev(){
        for j in (0..N-1).rev(){

            grid[i][j]=grid[i][j+1]+grid[i+1][j];
        }
    }

    for (_i, row) in grid.iter_mut().enumerate() {
        for (_y, col) in row.iter_mut().enumerate() {
            print!("{}  ", col);
        }
        println!("");
    }
    println!("");
    print!(" No. of paths by which we can reach to the destination are {} ", grid[0][0]);
}

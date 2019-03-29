const N: usize = 4;
fn main() {

    let mut grid = [[1, 2, 3, 4],
                    [5, 6, 7,8],
                    [9, 10, 11,12],
                    [13, 14, 15,16]];
    for i in 0..(N/2) {
        for j in i..(N-i-1) {
            let temp = grid[i][j];
            grid [i][j] = grid[j][N-1-i];
            grid[j][N-1-i] = grid[N-1-i][N-1-j];
            grid[N-1-i][N-1-j] = grid[N-1-j][i];
            grid[N-1-j][i] = temp;
        }
    }

    for i in 0..N {
        for j in 0..N {
            print!("{}  ",grid[i][j]);
            //if i==0 ||i==1 {
                //print!(" ");
        //    }
        }
        println!("");
    }
}

const M: usize = 10;
const N: usize = 10;
fn main() {

    let mut counter=0;
    let mut grid = [[0 as u8; N] ; M];
    for i in 0..10 {
        for j in 0..10 {
            counter+=1;
            grid[i][j] = counter;
        }
    }

    create_the_sieve(&mut grid);

    for i in 0..10 {
        for j in 0..10 {
            print!("{}  ",grid[i][j]);
        }
        println!("");
    }
}
fn create_the_sieve(grid :&mut [ [ u8; N] ; M]) {
    grid[0][0] = 0;

    for i in 0..M {
        for j in 0..N {
            if grid[i][j]!=0 {
                if check_prime(grid[i][j]){
                    println!("{}",grid[i][j]);
                    remove_multiples(grid[i][j],i,j,*grid);
                }
            }
        }
    }
}
fn check_prime(number : u8) -> bool {
    let mut counter=0;
    let mut prime : bool =false;
    for i in 2..number {
        if number%i==0{
            counter += 1;
        }
    }
    if counter==0 {
        prime = true;
    }
    prime
}
fn remove_multiples(number : u8,start1 : usize ,start2 : usize,mut grid : [[u8;N];M]) {

    for i in start1..M {
        for j in start2..N {
            if grid[i][j]%number==0 && grid[i][j]!=number {
                grid[i][j] = 0;
            }
        }
    }
}

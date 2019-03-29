const M : usize = 10;
fn main() {

    let mut value = abs(-4);
    println!("Hello, world! {}",value);
    value = abs(4);
    println!("Hello, world! {}",value);
    //let queen;
    let mut input = String::new();
    println!("Enter the number of queen");
    std::io::stdin().read_line(&mut input).unwrap();
    let n : u8 = input.trim().parse().unwrap();

    n_queens_placement(1,n);
}
fn abs(x: i32) -> i32 {
    print!("The abs value of {} is ", x);

    if x > 0 {
        return x;
    } else {
        -x
    }
}
fn place(k : usize , l : u8 ,array : &mut [i32;M]) -> bool {
    for i in 1..k {
        if array[i] == l as i32 || abs((i-k) as i32)==abs((array[i]-(l as i32))as i32) {
            return false;
        }
    }
    return true;
}
fn n_queens_placement(k : usize , n : u8) {

    let mut iCount = 0;
    let mut x_array  = [0 as i32;M];
    for i in 1..=n {
        println!("First loop");
        println!("calling place");
        if place(k,i,&mut x_array) {
            println!("called place");
            x_array[k] = i as i32;
            if k==(n as usize) {
                iCount += 1;
                println!("Feasible Solution : {}",iCount);
                println!("Solution : ");
                for j in 1..=n {
                    println!("first inner loop");
                    print!("{}",x_array[j as usize]);
                }
                for l in 1..=n {
                    println!("second inner loop");
                    println!("");
                    for p in 1..=n {
                        if p==x_array[l as usize] as u8 {
                            print!("Q");
                        }
                        else {
                            print!("0");
                        }
                    }
                }
            }
            else {
                println!("calling n_queens_placement");
                n_queens_placement(k+1,n);
                println!("called n_queens_placement");
            }
        }
    }
}

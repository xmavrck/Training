use std::io;
fn main() {

    println!("Enter the number of the stairs to climb");
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let no_of_stairs : u8 = input.trim().parse().unwrap();

    println!("Total possible ways are : {}",find_the_steps(no_of_stairs));

}
fn find_the_steps(total_steps : u8) -> u64 {

    if total_steps==1||total_steps==0 {
        return 1 as u64;
    }
    else if total_steps == 2 {
        return 2 as u64;
    }
    else {
        return (find_the_steps(total_steps-3)+find_the_steps(total_steps-2)+find_the_steps(total_steps-1)) as u64;
    }
}

fn main() {
    let first_term : u8 = 0;
    let second_term : u8 = 1;
    println!("Please enter the number of terms you want in the series : ");
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap();
    let terms : u8 = input.trim().parse().unwrap();
    print!("Fibonacci series for the {} terms is as follows :  ",terms);
    print!("{} , ",first_term);
    print!("{}",second_term);
    print_fibonacci_series(first_term,second_term,terms-2);
    println!("");

}
fn print_fibonacci_series(first_term : u8,second_term : u8, n : u8) {

    if n==0 {
        return
    }
    let next_term =first_term+second_term;
    print!(" , {}",next_term);
    print_fibonacci_series(second_term,next_term,n-1);
}

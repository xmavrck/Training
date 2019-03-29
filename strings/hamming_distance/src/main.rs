fn main() {

    use std::io::{stdin,stdout,Write};

    let mut s = String::new();
    print!("Please enter the first String: ");
    let _=stdout().flush();
    stdin().read_line(&mut s).expect("Did not enter a correct string");
    if let Some('\n')=s.chars().next_back() {
        s.pop();
    }
    if let Some('\r')=s.chars().next_back() {
        s.pop();
    }

    let mut d = String::new();
    print!("Please enter the second String: ");
    let _=stdout().flush();
    stdin().read_line(&mut d).expect("Did not enter a correct string");
    if let Some('\n')=d.chars().next_back() {
        d.pop();
    }
    if let Some('\r')=d.chars().next_back() {
        d.pop();
    }
    if s.len() == d.len() {
        let size : usize = calculate_hamming_distance(&s,&d);
        println!("The hamming Distance between the strings is : {}",size);
    }
    else {
        println!("Hamming Distance can't be calculated as the Strings are of unequal length");


    }

}

fn calculate_hamming_distance(_key1 : &str,_key2 : &str) -> usize {

    let n1 = _key1.len();
    let n2 = _key2.len();
    let mut counter = 0;

    if n1==n2 {

        for i in 0..n1{

            if _key1.chars().nth(i).unwrap() != _key2.chars().nth(i).unwrap() {

                counter = counter+1;
            }
        }
    }
    counter
}

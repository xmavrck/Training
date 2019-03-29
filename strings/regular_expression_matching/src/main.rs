extern crate regex;
use regex::Regex;
use std::io;
fn main() {

    let regular_expression = Regex::new(r"(\w{5})").unwrap();

    println!("Enter the String");
    let mut input_string = String::new();
    io::stdin().read_line(&mut input_string).unwrap();

    match regular_expression.captures(&input_string) {

        Some(caps) => println!("Found match : {} ",caps.get(0).unwrap().as_str()),
        None => println!("Could not find")
    }
}

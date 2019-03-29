fn main() {

    let mut input_string = String::new();
    println!("Enter the original String ");
    std::io::stdin().read_line(&mut input_string).unwrap();

    let mut pattern_string = String::new();
    println!("Enter the pattern you want to find in the string : ");
    std::io::stdin().read_line(&mut pattern_string).unwrap();

    let found = check_pattern_presence(input_string,pattern_string);
    if found == 1 {
        println!("Pattern present in the Input string");
    }
    else {
        println!("Pattern not present in the Input string");
    }
}
fn check_pattern_presence(input_string : String, pattern_string: String) -> usize {

    let input_string_length : usize = input_string.len();
    let pattern_string_length : usize = pattern_string.len();

    let mut found = 0 ;
    for i in 0..(input_string_length-pattern_string_length) {
        let mut position = 0;
        for j in i..(pattern_string_length+i) {

            if input_string.chars().nth(j).unwrap() == pattern_string.chars().nth(position).unwrap() {
                position+=1;
            }
        }
        if position == pattern_string_length-1 {
            found =1;
            break ;
        }
    }
    found
}

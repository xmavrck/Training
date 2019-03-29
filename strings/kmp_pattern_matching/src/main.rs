const M : usize = 10;
fn main() {

    println!("Enter the first String");
    let mut input_string = String::new();
    std::io::stdin().read_line(&mut input_string).unwrap();

    println!("Enter the second String");
    let mut pattern_string = String::new();
    std::io::stdin().read_line(&mut pattern_string).unwrap();

    kmp_pattern_search(&input_string,&pattern_string);
    println!("Done");
}

fn kmp_pattern_search(input_string : &String, pattern_string : &String) {

    let input_string_length = input_string.len()-1;
    let pattern_string_length = pattern_string.len()-1;
    println!("{}  {}", input_string_length,pattern_string_length);

    let mut  lps_array = [0 as usize;10];
    compute_lps_array(&pattern_string,pattern_string_length,&mut lps_array);
    let mut i = 0;
    let mut j = 0;
    while i < input_string_length {

        if pattern_string.chars().nth(j).unwrap() == input_string.chars().nth(i).unwrap() {
            j += 1;
            i += 1;
        }
        if j == pattern_string_length {
            println!("Found pattern at index : {}",i-j);
            j = lps_array[j-1];
        }
        else if i<input_string_length && pattern_string.chars().nth(j).unwrap() != input_string.chars().nth(i).unwrap() {
            if j != 0 {
                j = lps_array[j-1];
            }
            else {
                i += 1;
            }
        }
    }
}
fn compute_lps_array (pattern_string : &String , pattern_string_length : usize , lps_array : &mut [usize;M]) {

    let mut length = 0;
    lps_array[0] = 0;
    let mut i = 1;
    while i < pattern_string_length {
        if pattern_string.chars().nth(i).unwrap() == pattern_string.chars().nth(length).unwrap() {
            length += 1;
            lps_array[i] = length;
            i += 1;
        }
        else {
            if length != 0 {
                length = lps_array[length - 1];
            }
            else {
                lps_array[i] = 0;
                i += 1;
            }
        }
    }
}

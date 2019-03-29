fn main() {

    println!("Enter the Set");
    let mut input_string = String::new();
    std::io::stdin().read_line(&mut input_string).unwrap();

    let current_string : String = "".to_string();

    println!("");
    println!("Power set for the given set is as follows : ");
    power_set(&input_string,0,&current_string);
    println!("DONE!");

}

fn power_set(input_string : &String, index : usize, current_string : &String){

    let input_string_length = input_string.len() - 1;
    if index == input_string_length {
        print!("{}  ",current_string);
        return
    }
    let now : String = format!("{}{}",current_string,input_string.chars().nth(index).unwrap());
    power_set(input_string,index+1, &now);
    power_set(input_string, index+1, current_string);
}

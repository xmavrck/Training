use std::io;
const M : usize = 32;

fn main() {

    let mut index: [std::string::String; M] = Default::default();
    let mut choice = 1;
    while choice == 1 {

        println!("**********MENU**********");
        println!("press 1 to insert new value");
        println!("press 2 to delete value");
        println!("press 3 to search value");
        println!("press 4 to print the value");

        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let menu_choice: u8 = input.trim().parse().unwrap();

        println!("Enter the string you want to store");
        let mut input_string = String::new();
        io::stdin().read_line(&mut input_string).unwrap();

        let hash_index = hash_function(&input_string);
        println!("{}",hash_index);

        if menu_choice==1 {
            println!("Adding");
            add_element(&mut index, hash_index, &input_string);
        }
        else if menu_choice == 2 {
            println!("Deleting");
            delete_element(&mut index, hash_index, &input_string);
        }
        else if menu_choice == 3 {
            println!("Searching");
            search_element(&mut index, hash_index, &input_string);
        }
        else if menu_choice==4 {

            println!("{}",index[0]);
        }
        else {
            println!("Wrong selection!!! Enter the correct choice : ");
            continue;
        }
        println!("Do you want to continue : 0 for no/1 for yes");
        input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        choice = input.trim().parse().unwrap();
    }
}

fn hash_function(input_string1 : &String) -> usize {

    println!("input string = {}",input_string1);
    let string_length : usize = input_string1.len();
    let mut sum : i32 = 0;
    for i in 0..string_length {
        sum += ((*input_string1).chars().nth(i).unwrap()) as i32;
    }
    println!("{}",sum);
    let hash_index = (sum as usize) % M;
    println!("{}",hash_index);
    hash_index
}

fn add_element(array : &mut [String;M], mut hash_index : usize, value : &String) {

if array[hash_index]==""{

    array[hash_index] = value.to_string();
}
else {

    while array[hash_index] != "" {
           hash_index += 1;
           if hash_index == M {
               hash_index = 0;
           }
       }
       array[hash_index] = value.to_string();
   }
   println!("{}",array[hash_index]);
   println!("value added at location : {}",hash_index+1);
}
fn delete_element(array : &mut [String;M], mut hash_index : usize, value : &String) {

    while array[hash_index] != *value {
        hash_index += 1;
        if hash_index == M {
            hash_index = 0;
        }
    }
    array[hash_index] = ("").to_string();
println!("value deleted from location : {}",hash_index+1);
}

fn search_element(array : &mut [String;M], mut hash_index : usize, value : &String) {

        while array[hash_index] != *value {
            hash_index += 1;
            if hash_index == M {
                hash_index = 0;
            }
        }
        print!("The value {} is found at location : {}",value, hash_index+1);
}

use std::io;
const M : usize = 50;
fn main() {
    let mut index = [-1 as i32;M];
    let mut choice = 1;
    while choice == 1 {

        println!("**********MENU**********");
        println!("press 1 to insert new value");
        println!("press 2 to insert delete value");
        println!("press 3 to insert search value");

        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let menu_choice: u8 = input.trim().parse().unwrap();

        println!("Enter the key and the value");
        input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let key: u16 = input.trim().parse().unwrap();

        input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let value: i32 = input.trim().parse().unwrap();

        let hash_index = hash_function(key);

        if menu_choice==1 {
            println!("Adding");
            add_element(&mut index, hash_index, value);
        }
        else if menu_choice == 2 {
            println!("Deleting");
            delete_element(&mut index, hash_index, value);
        }
        else if menu_choice == 3 {
            println!("Searching");
            search_element(&mut index, hash_index, value);
        }
        else if menu_choice==4 {
            choice = 0;
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
fn hash_function(key : u16) -> usize {

    let hash_index : usize = (key%20) as usize;
    hash_index
}
fn add_element(array : &mut [i32;M], mut hash_index : usize, value : i32) {

    if array[hash_index]==-1{

        array[hash_index] = value;
    }
    else {

        while array[hash_index] != -1 {
               hash_index += 1;
               if hash_index == M {
                   hash_index = 0;
               }
           }
           array[hash_index] = value;
    }
    println!("value added at location : {}",hash_index+1);
}
fn delete_element(array : &mut [i32;M], mut hash_index : usize, value : i32) {

        while array[hash_index] != value {
            hash_index += 1;
            if hash_index == M {
                hash_index = 0;
            }
        }
        array[hash_index] = -1;
    println!("value deleted from location : {}",hash_index+1);
}
fn search_element(array : &mut [i32;M], mut hash_index : usize, value : i32) {

            while array[hash_index] != value {
                hash_index += 1;
                if hash_index == M {
                    hash_index = 0;
                }
            }
            println!("The value {} is found at location : {}",value, hash_index+1);
}

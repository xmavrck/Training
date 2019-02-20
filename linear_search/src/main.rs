const M : usize = 20;
fn main() {

    let components : [u8;M] = [45,63,88,52,98,64,78,15,32,89,77,79,84,48,51,62,29,45,88,22];
    let found_position : u8 = linear_search(components) as u8;
    if found_position!=0 {
        println!("The element is found at the position : {}",found_position+1);
    }
    else {
        println!("The element is not found");
    }
}
fn linear_search(_components : [u8;20]) -> usize {

    let mut _input = String::new();
    println!("Enter the element you want to search in the array : ");
    std::io::stdin().read_line(&mut _input).unwrap();
    let key = _input.trim().parse().unwrap();

    for i in 0..(_components.len()) {

        if _components[i] == key {
            return i
        }
    }
    return 0
}

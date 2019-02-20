const M : usize = 19;
fn main() {

    let components : [u8;M] = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,18,19,20,24];

    let mut input = String::new();
    println!("Enter the element you want to search in the array : ");
    std::io::stdin().read_line(&mut input).unwrap();
    let key : u8= input.trim().parse().unwrap();

    let found_position : usize = binary_search(components,0,M,key);
    if found_position!=0 {
        println!("The element is found at the position : {}",found_position+1);
    }
    else {
        println!("The element is not found");
    }
}
fn binary_search(_components : [u8;M],lower : usize ,upper : usize ,_key : u8) ->usize {

    if upper >= lower {
        let middle_point = (upper+lower)/2;
        if _components[middle_point]==_key {
            return middle_point
        }
        else if _key < _components[middle_point] {
            return binary_search(_components, lower,middle_point-1, _key);
        }
        else if _key > _components[middle_point] {
            return binary_search(_components, middle_point+1, upper, _key);
        }
        else {

            return 0
        }
    }
    else {
        return 0;
    }
}

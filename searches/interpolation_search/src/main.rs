const M : usize = 19;
fn main() {

    let components : [u8;M] = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,18,19,20,24];

    let mut input = String::new();
    println!("Enter the element you want to search in the array : ");
    std::io::stdin().read_line(&mut input).unwrap();
    let key : u8= input.trim().parse().unwrap();

    let found : i32 = interpolation_search_key(components,key);
    if found == -1 {
        println!("Element is not present in the given array");
    }
    else {
        println!("Element found at position : {}",found);
    }
}
fn interpolation_search_key(_components : [u8;M],_key : u8) ->i32 {

    let mut lower = 0;
    let mut upper = M-1;
    while lower<=upper && _key>=_components[lower] && _key<=_components[upper] {

        if lower==upper {
            if _components[lower]==_key {
                return lower as i32;
            }
            else {
                return -1 as i32;
            }
        }
        let mut position = lower as i32 + ((upper-lower) as i32 / (_components[upper]-_components[lower]) as i32 *(_key as i32 -_components[lower] as i32));
        if _components[position as usize] == _key {
            return position as i32;
        }
        if _components[position as usize]< _key {
            lower = position as usize +1;
        }
        else {
            upper = position as usize -1;
        }
    }
    return -1 as i32;
}

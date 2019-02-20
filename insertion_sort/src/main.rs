const M : usize = 19;
fn main() {
    //array of 19 elements in random order
    let mut _components : [u8;M] = [1,8,6,7,9,3,4,5,2,10,19,15,50,12,16,14,13,29,22];

    for i in 0..M {
        let mut locator = i;   // to store the location or position

        while locator > 0 && _components[locator-1] > _components[locator] {
            //while loop running in backward direction to find and insert the element at the correct position
            let mut swapper: u8 = _components[locator];
            _components[locator] = _components[locator-1];
            _components[locator-1] = swapper;
            locator -= 1;
        }

    }
    //printing the sorted array
    println!("The elements of the array in ascending array are : ");
    for  i in 0..M {
        print!("{}  ",_components[i]);
    }
}

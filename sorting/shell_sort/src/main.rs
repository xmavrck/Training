const M : usize = 19;
fn main() {

    let mut components : [u8;M] = [5,2,24,4,1,6,20,8,9,25,14,12,88,14,15,10,19,7,3];

    println!("Array before sorting....");
    for i in 0..19 {
        print!("{}  ",components[i]);
    }
    shell_sort(&mut components,M);
    println!("");
    println!("Array after sorting....");
    for i in 0..M {
        print!("{}  ",components[i]);
    }
    println!("");
}
fn shell_sort(array : &mut [u8;M] , n : usize) {

    let mut gap = n/2;
    while gap > 0 {
        for i in gap..n {
            let temp = array[i];
            let mut j = i;
            while j>=gap && array[j-gap] > temp {

                array[j] = array[j-gap];
                j -= gap;
            }
            array[j] = temp ;
        }
        gap /=2;
    }
}

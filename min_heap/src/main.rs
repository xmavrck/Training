fn main() {
    let mut numbers : [i32;17]= [17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1];
    /*for n in numbers.iter(){
        println!("{}",n);
    }*/

    let size = numbers.len();
    let last_parent_index = size/2;
    for n in (0..last_parent_index).rev() {
        max_heapify(&mut numbers,n);
    }

    for i in 0..17{
        println!("{}", numbers[i]);
    }
}

fn max_heapify(numbers: &mut [i32], n : usize) {

    let l = (2*n)+1;
    let r = (2*n)+2;
    let mut lowest : usize;
    if l< numbers.len() && numbers[l]<numbers[r] {
        lowest = l;
        }
    else {
        lowest = n;
    }
    if r<numbers.len() && numbers[r]<numbers[lowest] {

        lowest = r;
    }
    if lowest!=n {

        let temp = numbers[n];
        numbers[n] = numbers[lowest];
        numbers[lowest] = temp;
        max_heapify(numbers,lowest);
    }

}

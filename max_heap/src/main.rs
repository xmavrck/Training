fn main() {
    let mut numbers : [i32;17]= [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17];
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
    let mut largest : usize;
    if l< numbers.len() && numbers[l]>numbers[r] {
        largest = l;
        }
    else {
        largest = n;
    }
    if r<numbers.len() && numbers[r]>numbers[largest] {

        largest = r;
    }
    if largest!=n {

        let temp = numbers[n];
        numbers[n] = numbers[largest];
        numbers[largest] = temp;
        max_heapify(numbers,largest);
    }

}

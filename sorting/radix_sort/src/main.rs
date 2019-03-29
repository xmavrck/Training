const M : usize = 8;

fn main() {

    let mut components : [u8;M] = [24,4,25,14,12,88,19,7];

    println!("Array before sorting....");
    for i in 0..M {
        println!("{} : {}",i,components[i]);
    }
    let n = M;
    radix_sort(&mut components, n);

    println!("Array after sorting....");
    for i in 0..M {
        println!("{} : {}",i,components[i]);
    }
}

fn get_max(array : &mut[u8;M],n : usize) -> u8 {

    let mut mx =array[0];
    for i in 1..n {
        if array[i] > mx {
            mx=array[i];
        }
    }
    mx
}
fn radix_sort(array : &mut [u8;M] , n : usize) {

    let m = (get_max(array, n)) as usize;
//    println!("called get_max  and m = {}",m);
    let mut exp = 1;
    while (m/exp) > 0 {
//        println!("calling count_sort");
        count_sort(array,n,exp);
//        println!("called count_sort");
        exp *= 10;
    }
//    println!("Radix sort");
}
fn count_sort(array : &mut [u8;M], n : usize, exp : usize) {

    let mut output = [0 as u8;M];
    let mut count = [0 as u8;10];
    for i in 0..n {
        count[ (array[i] as usize/exp)%10 ] += 1;
    }
//    println!("First loop done");
    for i in 1..10 {
        count[i] += count[i-1];
    }
//    println!("second loop done");
    for i in (0..n).rev() {
//        println!("before working");
        output[((count[ (array[i] as usize/exp)%10 ]) -1) as usize] = array[i];
//        println!("after working");
        count[ (array[i] as usize/exp)%10 ] -= 1;
    }
//    println!("third loop done");
    for i in 0..n {
        array[i] = output[i];
    }
//    println!("Fourth loop done");
}

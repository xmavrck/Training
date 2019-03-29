const M : usize = 19;
fn main() {

    let components : [i32;M] = [1,-2,-3,4,-5,6,7,-8,9,-10,11,12,-13,-14,15,18,-19,-20,24];
    let answer : i32 = max_sum_subarray(components,components.len());
    println!("{}",answer);

    //println!("Hello, world!");
}

fn max_sum_subarray(_array : [i32;M], size : usize ) -> i32 {

    let mut answer : i32 = -9999;
    for start_index in 0..size {

        let mut sum : i32 = 0;
        for sub_array_size in 1..=size {

            if (start_index+sub_array_size) > size {
                break;
            }
            sum += _array[start_index+sub_array_size-1];
            answer = std::cmp::max(answer,sum);
        }
    }
    answer
}

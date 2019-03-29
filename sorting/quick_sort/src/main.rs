fn main () {
    let vector = vec![9,95,66,8,55,5,3,76,39,45,65,24,15,35,34];
    let result = quick_sort(vector);
    println!("{:?}",result);
}
fn quick_sort (vector:Vec<i32>) -> Vec<i32> {
    if vector.len() > 1 {
        let pivot = vector[0];
        let mut less = Vec::new();
        let mut equals = Vec::new();
        let mut greater = Vec::new();

        for value in vector {
            if value > pivot {
                greater.push(value);
            }
            if value < pivot {
                less.push(value);
            }
            if value == pivot {
                equals.push(value);
            }
        }
        let mut final_vector = Vec::new();
        final_vector.extend(quick_sort(less));
        final_vector.extend(equals);
        final_vector.extend(quick_sort(greater));
        return final_vector;
    }
    return vector;
}

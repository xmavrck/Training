const M : usize = 16;
fn main() {

    let mut components : [u8;M] = [1,2,3,4,5,6,9,11,12,14,15,18,19,20,24,50];

    let mut input = String::new();
    println!("Enter the element you want to search in the array : ");
    std::io::stdin().read_line(&mut input).unwrap();
    let key : u8= input.trim().parse().unwrap();

    let position : i32 = block_search(&mut components,key,M);
    if position != -1 {
        println!("Element {} found at position : {}",key ,position+1);
    }
    else {
        println!("Element not found");
    }
}

fn block_search(array : &mut [u8;M], x: u8, n : usize ) -> i32 {

    let step_sqrt = f64::from(n as f64).sqrt();
    let mut step : usize = step_sqrt.floor() as usize;
    let mut prev : usize = 0;
    while array[min(step, n)-1] < x {

        prev = step;
        step += (f64::from(n as f64).sqrt()) as usize;
        if prev >= n{
            return -1;
        }
    }
    while array[prev] < x {
        prev += 1;
        if prev == min(step,n) {
            return -1;
        }
    }
    if array[prev] == x {
        return prev as i32;
    }
    return -1;
}
fn min(number1 : usize, number2 : usize) -> usize{

    if number1 > number2 {
        return number2;
    }
    else {
        return number1;
    }
}
/*

int jumpSearch(int arr[], int x, int n)
{
    // Finding block size to be jumped
    int step = sqrt(n);

    // Finding the block where element is
    // present (if it is present)
    int prev = 0;
    while (arr[min(step, n)-1] < x)
    {
        prev = step;
        step += sqrt(n);
        if (prev >= n)
            return -1;
    }

    // Doing a linear search for x in block
    // beginning with prev.
    while (arr[prev] < x)
    {
        prev++;

        // If we reached next block or end of
        // array, element is not present.
        if (prev == min(step, n))
            return -1;
    }
    // If element is found
    if (arr[prev] == x)
        return prev;

    return -1;
}
*/

const M : usize = 50;
fn main() {

    let number : u16 = 10;
    //partition(4);
    partition(number);
    //let number : i32 = partition(sum,largestNumber);
    //println!("{}  ",number);
}
fn partition(number : u16) {

    let mut partition_array : [u16;M] = [0;50];
    let mut k : usize = 0;
    partition_array[k] = number;
    loop {
        print_array(partition_array,k+1);
        let mut remaining_value = 0;
        while k >= 0 && partition_array[k]==1 {
            remaining_value +=partition_array[k];
            k -= 1;
        }
        if k < 0 {
            return
        }
        partition_array[k] -= 1;
        remaining_value += 1;
        while remaining_value > partition_array[k] {
            partition_array[k+1] = partition_array[k];
            remaining_value = remaining_value - partition_array[k];
            k += 1;
        }
        partition_array[k+1] = remaining_value;
        k += 1;
    }
}

fn print_array(partition_array : [u16;M],number : usize) {

    println!("");
    for i in 0..number {
        print!("{}  ",partition_array[i]);
    }
}
/*
void printArray(int p[], int n)
{
    for (int i = 0; i < n; i++)
       cout << p[i] << " ";
    cout << endl;
}
*/

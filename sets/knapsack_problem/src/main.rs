use std::io;
const M: usize = 6;
const ITEMS : usize = 3;
fn main() {

    let mut value_grid = [[0 as u16; M] ; ITEMS];
    println!("Please enter the weights and the value of the items in descending order of value per weight");
    for i in 0..ITEMS {
        let mut _input1 = String::new();
        io::stdin().read_line(&mut _input1).unwrap();
        let weight : u16 = _input1.trim().parse().unwrap();
        value_grid[i][0] = weight;
        let mut _input2 = String::new();
        io::stdin().read_line(&mut _input2).unwrap();
        let value : u16 = _input2.trim().parse().unwrap();
        value_grid[i][1] = value;
    }
    println!("Please enter the capacity of the knapsack");

    let mut _input3 = String::new();
    io::stdin().read_line(&mut _input3).unwrap();
    let knapsack_capacity : u16 = _input3.trim().parse().unwrap();

    for _i in 0..ITEMS {
        value_grid[_i][2] = value_grid[_i][1]/value_grid[_i][0];
    }
    println!("Item no.   Weight   Value   Value/Weight");
    for _i in 0..ITEMS {
        print!(" {}          ",_i+1);
        for _j in 0..3{
            print!("{}       ",value_grid[_i][_j]);
        }
        println!("");
    }

    let mut remaining_knapsack_capacity : u16 = knapsack_capacity;
    let mut net_profit = 0;
    println!("Calculating maximum profit that can be achieved...");
    for _i in 0..ITEMS {
        let max_value_element = find_max(&mut value_grid);
        if remaining_knapsack_capacity >= value_grid[max_value_element][0] {
            remaining_knapsack_capacity -= value_grid[max_value_element][0];
            net_profit += value_grid[max_value_element][1];
            println!("Select item no. : {}",max_value_element+1);
        }
    }
    println!("Net Profit that can be earned is : {}",net_profit);
}
fn find_max(array : &mut [[u16;M];ITEMS]) -> usize {

    let mut max = 0;
    let mut position = 0;
    for i in 0..ITEMS {
        if max < array[i][2] {

            max = array[i][2];
            position = i;
        }
    }
    array[position][2] = 0;
    return position;
}

use std::io;
const V : usize = 6;
const MAX : u16 = 1000;
const M: usize = 6;
const N: usize = 6;
fn main() {

    let node_names = ['a','b','c','d','e','f'];
    let mut cost_grid = [[0 as i32; N] ; M];

    for i in 0..M {

        for j in 0..N {

            if i>j {
                println!("If there is a path between {} and {} press 1 or else press 0 : ",node_names[i],node_names[j]);
                //checking if there is a path between the two nodes
                let mut input = String::new();
                io::stdin().read_line(&mut input).unwrap();
                let n: u8 = input.trim().parse().unwrap();
                if n==1 {
                    //if path exists the cost has to entered in the adjacency matrix
                    println!("Enter the cost : ");
                    //Entering the cost of the traversing between the two nodes
                    let mut input_2 = String::new();
                    io::stdin().read_line(&mut input_2).unwrap();
                    let n2: i32 = input_2.trim().parse().unwrap();

                    cost_grid[i][j] = n2;
                    cost_grid[j][i] = n2;
                }
                else {
                    cost_grid[i][j] = 0;
                }
            }
            else if i==j {
                cost_grid[i][j]=0;
            }
        }
    }
    for (_i, row) in cost_grid.iter_mut().enumerate() {
        for (_y, col) in row.iter_mut().enumerate() {
            print!("{}  ", col);
        }
        println!("");
    }
    bellman_ford_algorithm(cost_grid);

}

fn bellman_ford_algorithm(cost_grid : [[i32;6];6]) { // pay attention Here

    let mut visited = [false as bool;V];
    let mut distance = [0 as i32;V];
    distance[0] = 0;
    for i in 1..V {
        distance[i] = MAX as i32;
    }
    for _i in 0..(V-1) {
        let min_vertex : usize= find_min_vertex(distance,visited) as usize;//pay attention Here
        visited[min_vertex] = true;
        for j in 0..V {
            if cost_grid[min_vertex][j]!=0 && !visited[j] && distance[min_vertex]!=(MAX as i32) {
                let new_distance = distance[min_vertex] + cost_grid[min_vertex][j];
                if new_distance<distance[j]{
                    distance[j] = new_distance;
                }
            }
        }
    }
    for i in 0..V {

        println!("{} -> {}",i,distance[i]);
    }
}
fn find_min_vertex(distance : [i32;6], visited : [bool;6]) ->i32 { // pay attention Here

    let mut min_vertex : i32 = -1;
    for i in 0..6 {
        if !visited[i] && (min_vertex == -1 ||distance[i]<distance[min_vertex as usize]) {
            min_vertex = i as i32;
        }
    }
    min_vertex
}

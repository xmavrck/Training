const M: usize = 3;
const N: usize = 3;
fn main() {

    let grid1 : [u8;M] = [1,2,3];
    let grid2 : [u8;M] = [4,5,6];

    println!("cartesian_product of grid1 * grid2 is :");
    cartesian_product(grid1,grid2);
}

fn cartesian_product(grid1 :[u8;N],grid2 :[u8;N]) {

    for i in 0..N {
        for j in 0..N {
            print!("({},{})  ",grid1[i],grid2[j]);
        }
        println!("");
    }
}

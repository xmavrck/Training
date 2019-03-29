const M : usize = 8;

fn main() {

    let pillar_sizes : [u8;M] = [0,1,0,2,1,0,1,3];
    let mut water_trapped = 0;

    for i in 1..(pillar_sizes.len()) {

        let left_pillar : u8 = find_left_max_pillar(pillar_sizes,i);
        let right_pillar : u8 = find_right_max_pillar(pillar_sizes,i);
        print!("{}  ",left_pillar);
        print!("{}",right_pillar);
        water_trapped += calculate_water_trapped(left_pillar,right_pillar,pillar_sizes[i]);

        println!("");

    }
    println!("water_trapped is  :  {}",water_trapped);
}
fn find_left_max_pillar(pillar_sizes : [u8;M] , n : usize) -> u8{

    let mut left_max : u8 = 0;
    for i in 0..=n {

        if pillar_sizes[i]>left_max {

            left_max = pillar_sizes[i];
        }
    }
    left_max
}

fn find_right_max_pillar(pillar_sizes : [u8;M], n : usize) ->u8 {

    let mut right_max : u8 = 0;
    for i in n..(pillar_sizes.len()) {

        if pillar_sizes[i]>right_max {

            right_max = pillar_sizes[i];
        }
    }
    right_max
}
fn calculate_water_trapped(left_pillar : u8,right_pillar : u8, height : u8) ->u8 {

    let shorter_pillar = std::cmp::min(left_pillar,right_pillar);
    let water : u8 = (shorter_pillar - height) as u8;
    water
}

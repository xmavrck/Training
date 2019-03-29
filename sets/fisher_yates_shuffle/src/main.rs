extern crate rand;
use rand::Rng;
const M : usize = 19;
fn main() {

    let mut components : [u8;M] = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,18,19,20,24];
    shuffle_it_up(&mut components);

    for i in 0..M {
        print!("{}  ",components[i]);
    }

}
fn shuffle_it_up(components : &mut [u8]) {

    let mut random_number ;
    for i in (1..M).rev() {
        random_number = random_no_generator(0,i);
        while random_number==i {
            random_number = random_no_generator(0,i);
        }
        let _change : u8 = components[i];
        components[i] = components[random_number];
        components[random_number] = _change;
    }
}
fn random_no_generator(lower_limit : usize , upper_limit : usize) ->usize {

    let mut rng = rand::thread_rng();
    return rng.gen_range(lower_limit, upper_limit);
}

/*

*/

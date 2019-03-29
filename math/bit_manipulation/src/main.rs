fn main() {

    println!("performing bit shifting :");
    let mut byte_stream1: u8 = 0b0000_1000;
    println!("The original byte stream : 0b{:08b}",byte_stream1);
    byte_stream1 <<= 1; // shifting the bit one left
    println!("0b{:08b}", byte_stream1);

    byte_stream1 >>= 1; // shifting the bit one right
    println!("0b{:08b}", byte_stream1);

    //performing bit rotation

    println!("performing bit rotation :");
    let mut byte_stream2: u8 = 0b1000_0000;
    println!("The original byte stream : 0b{:08b}",byte_stream2);
    byte_stream2 = byte_stream2.rotate_left(1); // rotate left one bit
    println!("0b{:08b}", byte_stream2);

    byte_stream2 = byte_stream2.rotate_right(1); // rotate right one bit
    println!("0b{:08b}", byte_stream2);

    //println!("Hello, world!");
}

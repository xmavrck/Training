fn main() {
    let base = 6;
    let power = 6;
    let answer = fast_powering(base,power);
    println!("{}",answer);
}
fn fast_powering(base : i32, power : i32) -> i32 {

    let mut result=1;
    if power== 0 {

        return result;
    }

    result = base*fast_powering(base,power-1);
    return result;
}

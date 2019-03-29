fn main() {

    let mut input = String::new();
    println!("Enter the no.of discs you have to move : ");
    std::io::stdin().read_line(&mut input).unwrap();
    let no_of_discs : u8 = input.trim().parse().unwrap();

    let first_rig = "Start".to_string();
    let second_rig = "Middle".to_string();
    let third_rig = "Destination".to_string();
    tower_of_hanoi(no_of_discs,&first_rig,&second_rig,&third_rig);

}
fn tower_of_hanoi(no_of_discs: u8, first_rig : &str, second_rig : &str, third_rig : &str) {

    if no_of_discs == 1 {
        println!("{} --> {}",first_rig,third_rig);
        return
    }
    tower_of_hanoi(no_of_discs-1,first_rig,third_rig,second_rig);//sda
    println!("{} --> {}",first_rig,third_rig);
    tower_of_hanoi(no_of_discs-1,second_rig,first_rig,third_rig);  //asd
    return
}

fn main() {

    let mut input_string1 = String::new();
    std::io::stdin().read_line(&mut input_string1).unwrap();

    let mut input_string2 = String::new();
    std::io::stdin().read_line(&mut input_string2).unwrap();

    let input_string1_length = input_string1.len();
    let input_string2_length = input_string2.len();
    let mut count : u8 = lcs(&input_string1,&input_string2,input_string1_length,input_string2_length);
    count -= 1;
    println!("{}",count);
}
fn lcs( input_string1:&String, input_string2 :&String,m : usize,n : usize ) -> u8
{
   if m == 0 || n == 0 {
       return 0;
   }
   if input_string1.chars().nth(m-1).unwrap() == input_string2.chars().nth(n-1).unwrap() {
       return 1 + lcs(&input_string1,&input_string2, m-1, n-1);
   }
   else {
        return std::cmp::max(lcs(&input_string1,&input_string2, m, n-1), lcs(&input_string1,&input_string2, m-1, n));
   }

}

/*
height: number of disks; serves as the problem size for recursion
srcP: the "from" tower is where the disks are placed
desP: the "to" tower is where the disks must be finally placed
via: the "via" tower is that used as an intermediate location as disks are moved between the towers from and to.
*/
function Hanoi(height, srcP, desP, via) {
  if (height >= 1) {

    // Move a tower of height-1 to the buffer peg, using the destination peg.
    Hanoi(height - 1, srcP, via, desP);

    // Move the remaining disk to the destination peg.
    console.log('Move disk from Tower ', srcP, ' to Tower ', desP);

    // Move the tower of `height-1` from the `buffer peg` to the `destination peg` using the `source peg`.        
    Hanoi(height - 1, via, desP, srcP);
  }
  
  return;
}

//test
let disks=prompt("enter number of disks");

//calling function
Hanoi(disks, "A", "C", "B");

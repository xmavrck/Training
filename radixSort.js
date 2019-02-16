function maximumNo(arr)
  {
    let max=0;
    for(let i of arr)
      {
        //comparing elements of array to find largest element
        if(max < i.toString().length)
          {
            max=i.toString().length;
          }
      }
    return max;
  }
// returns back number in that place.
function getPosition(num,place)
  {
    return Math.floor(Math.abs(num)/Math.pow(10,place))%10;
  }

function radixSort(arr) {

    const max = maximumNo(arr); // length of the max digit in the array

    for (let i = 0; i < max; i++) {
        let buckets = Array.from({ length: 10 }, () => [ ])
        for (let j = 0; j < arr.length; j++) {
          buckets[getPosition(arr[ j ], i)].push(arr[ j ]); // pushing into buckets
        }
        arr = [ ].concat(...buckets); //spread operator will combine previous values also
    }
    return arr
}
console.log(radixSort([2,3,7,5,3]));
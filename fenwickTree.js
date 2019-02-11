function constructTree(ar,n)
  {  
    if(ar == null || n<=0)
      {
        console.log("array is empty");
        return;
      }
    else
    {
          let bTree=[];
            for(let j=1;j<=n;j++)
              {
                bTree[j]=0;
              }
            for(let k=0;k<n;k++)
              {
                    updateTree(bTree,k,ar[k],n);
              }
            return bTree;
           }
  }
  function updateTree(bTree,index,value,n)
  {
    if(index<0 )
    {
      console.log("error");
      return;
    }
    else{
         index=index+1;
        while(index<=n)
          {
            bTree[index]+=value;
            index+=index & (-index);  //related nodes
          }
          }
  }
  function getSum(bTree,index)
  {
    
    index=index+1;
  
    let sum=0;
    console.log(index);
    while(index>0)
      {
        sum+=bTree[index];
        index =index-(index & (-index));  // go to parent node
      }
    console.log(sum);
    return sum;
  }

//test
let arr=[3,2,1,6,5,4,-3,3,7,2,3];
bT=constructTree(arr,arr.length);

updateTree(bT,1,4,11);
let four=getSum(bT,3);
console.log(four);
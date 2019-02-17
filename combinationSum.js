/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), this will find all unique combinations in candidates where the candidate numbers sums to target*/

/*The same repeated number may be chosen from candidates unlimited number of times.*/

function combinationSum(candidates, target) {
    var result = [];
 
    if(candidates == null || candidates.length == 0) return result;
 
    var current = [];
    candidates.sort();
 
    combinationRecursive(candidates, target, 0, current, result);
 
    return result;
}
 
function combinationRecursive(candidates, target, k,curr, result){
   if(target == 0){
       var temp = curr.slice();
       result.push(temp);
       return;
   }
   for(var i=k ; i<candidates.length; i++){
    
     if(target < candidates[i]) 
            return;
       curr.push(candidates[i]);
     
       combinationRecursive(candidates, target - candidates[i], i, curr, result);
       curr.pop(); 
   }
}

//test
let set=[];
var size=prompt("Enter the size: ");// Enter the size
for(var i=0;i<size;i++)
  {
    set[i]=prompt("Enter the number: ");// Taking input from user
    set[i]=parseInt(set[i]);
    
  }
var target=prompt("Enter the target: ");

console.log(combinationSum(set,target));
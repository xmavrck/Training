/*this program will generate possible routes */
function generatePermutations(Arr){
  var permutations = [];
  var A = Arr.slice();

  function swap(a,b){
    var tmp = A[a];
    A[a] = A[b];
    A[b] = tmp;
  }

  function generate(n, A){
    if (n == 1){
      permutations.push(A.slice());
    } else {
      for(var i = 0; i <= n-1; i++) {
        generate(n-1, A);
        swap(n % 2 == 0 ? i : 0 ,n-1);
      }
    }
  }
  generate(A.length, A);
  return permutations;
}


function generateCityRoutes(cities){
  var pems = generatePermutations(cities.slice(1));
  for (var i = 0; i < pems.length; i++){
    pems[i].unshift(cities[0]);
    pems[i].push(cities[0]);
  }
  return pems;
}
//test
console.log(generateCityRoutes([0,1,2,3]));


/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
function lcs(X, Y, m, n) {

   if (m == 0 || n == 0)

       return 0;

   if (X[m - 1] == Y[n - 1])

       return 1 + lcs(X, Y, m - 1, n - 1);

   else

       return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));

}function max(a, b) {

   return (a > b) ? a : b;

}

let s1 = prompt("enter first string");

let s2 = prompt("enter second string");

let m = s1.length;

let n = s2.length;

console.log("result is"+lcs(s1, s2, m, n));
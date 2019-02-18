/* this will place the queens in such a way that no two queens threaten each other*/
function queenPuzzle(rows, columns) {

   if (rows <= 0) {

       return [[]];

   } else {

       return addQueen(rows - 1, columns);

   }

}
function addQueen(newRow, columns, prevSolution) {

   var newSolutions = [];

   var prev = queenPuzzle(newRow, columns);

   for (var i = 0; i < prev.length; i++) {

       var solution = prev[i];

       for (var newColumn = 0; newColumn < columns; newColumn++) {

           if (!hasConflict(newRow, newColumn, solution))

               newSolutions.push(solution.concat([newColumn]))

       }

   }

   return newSolutions;

}
function hasConflict(newRow, newColumn, solution) {

   for (var i = 0; i < newRow; i++) {

       if (solution[i]     == newColumn          ||

           solution[i] + i == newColumn + newRow ||

           solution[i] - i == newColumn - newRow) {

               return true;

       }

   }

   return false;

}
//test

console.log(queenPuzzle(4,4));

/*
output will be
[1,3,0,2]
[2,0,3,1]

*/

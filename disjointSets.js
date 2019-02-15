let Set = function () {

   let arr = [];
   this.init = function (elements) {

       elements.forEach(element => {

           if (arr.indexOf(element) == -1) {

               arr.push(element);

           }        })

       console.log(arr);

   }

   this.isDisjoint = function (set1, set2) {

       let flag = true;

       set1.forEach(element => {

           if (set2.indexOf(element) != -1) {

               console.log('Sets are not Disjoint. The common element is: ' + element);

               flag = false;

           }

       });

       if (!flag) {

           return;

       }

       console.log('Sets are Disjoint.');

       return true;

   } 
   this.partition = function (elements, newSet) {

       elements.forEach(element => {

           if (arr.indexOf(element) != -1) {

               delete arr[arr.indexOf(element)];

               if (newSet.indexOf(element) == -1) {

                   newSet.push(element);

               }

           }

       })

       console.log('New set: ' + newSet);

       console.log('Source set: ' + arr);

   }    this.mergExistingSets = function (dest, sorc) {        for (let i = 0; i < sorc.length; i++) {

           let element = sorc.pop();

           if (dest.indexOf(element) == -1) {

               dest.push(element);

           }

       }

       console.log('Merge set: ' + dest);

   }

}
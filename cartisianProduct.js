class setElement{
	constructor(v1, v2){
		this.value1 = v1;
		this.value2 = v2;
	}
}

var res = [];

// set 1
var set1 = [];
var size1 = parseInt(prompt("enter size1"));
for (var i = size1 - 1; i >= 0; i--) {
	set1.push(parseInt(prompt()));
}

var set2 = [];
var size2 = parseInt(prompt("enter size2"));
for (var i = size2 - 1; i >= 0; i--) {
	set2.push(parseInt(prompt()));
}

// for loop on set 1
for (var i = 0; i < set1.length ; i++) {
	// for loop on set 2
	for (var j = 0; j < set2.length; j++) {
		res.push(new setElement(set1[i], set2[j]));		
	}	
}

for(var i = 0; i<res.length; i++){
	console.log("("+res[i].value1+", "+res[i].value2+")");
}
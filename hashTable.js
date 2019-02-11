var hashTable = function()
{
  this.storage= [];
  this.count = 0;
  this.limit = 8;
};


hashTable.prototype.insert = function(key , value)
{
  var index=this.hashFunction(key,this.limit);
  var bucket=this.storage[index];
  
  if(!bucket)
    {
      var bucket=[];
      this.storage[index]=bucket;
    }
    
    var flag= false;
    //check the bucket to see if any duplicate //key values are there
    //if found then override them
    for(let i=0;i< bucket.length;i++)
    {
      var tuple=bucket[i];
      if(tuple[0] === key)
        {
          //override it
          tuple[1]=value;
          flag= true;
        }
    }
    if(!flag)
      {
        bucket.push([key,value]);
        this.count++;
       
      }
  return this;
};

hashTable.prototype.hashFunction= function(str,value)
{
  var hash=0;
  for(let i=0;i<str.length;i++)
    {
      let letter=str[i];
      hash=(hash<<5) + letter.charCodeAt(0);
      hash=(hash & hash) % value;
    }
  return hash;
  
};

hashTable.prototype.remove = function(key)
{
  var index = this.hashFunction(key,this.limit);
  var bucket =this.storage[index];
  if(!bucket)
    {
      return;
    }
  for(var i=0;i< bucket.length;i++)
    {
      var tuple=bucket[i];
      
      if(tuple[0] === key)
        {
          bucket.splice(i , 1);
          //remove the tuple
          bucket.splice(i,1);
        this.count--;
    
      return tuple[1];
   
        }
      
    }
  
};
hashTable.prototype.getByKey =function(key)
{
  var index = this.hashFunction(key,this.limit);
  var bucket = this.storage[index];
  
  if(!bucket)
    {
      return null;
    }
  for(let i=0;i<bucket.length;i++)
    {
      let row=bucket[i];
      if(row[0] === key)
        {
          return tuple[1];
        }
    }
  return null;
};

hashTable.prototype.getAll= function()
{
  console.log(this.storage);
};


var ob=new hashTable();

ob.insert('avinashi','123 222');
ob.insert('akshay','122 222');
ob.insert('raman','124 222');
ob.insert('abhi','125 222');
ob.insert('richa','1 222');
ob.remove('richa');
ob.remove('abhi')
ob.getAll();

function stringmatching(string,pattern,n,m)// Function of stringmatching
{
  if(m==0)
    return (n==0);
  let lookup=[n+1][m+1];// Lookup Table
  memset(lookup,false,lookup.length);
  lookup[0][0]=true;
  for(let j=1;j<=m;j++)
    {
      if(pattern[j-1]=='*')
        lookup[0][j]=lookup[0][j-1];
    }
  for(let i=1;i<=n;i++)
    {
      for(let j=1;j<=m;j++)
        {
          if(pattern[j-1]=='*')
            lookup[i][j]=lookup[i][j-1] || lookup[i-1][j];
          else if(pattern[j-1]=='?' || string[i-1]==pattern[j-1])
            lookup[i][j]=lookup[i-1][j-1];
          else
            lookup[i][j]=false;
        }
    }
  return lookup[n][m];
}
let string=prompt("Enter the string: ");// Taking input from user
let pattern=prompt("Enter the pattern :");// Taking input from user
if(stringmatching(string,pattern,string.length,pattern.length))// Calling stringmatching Function
  console.log("Yes");
else
  console.log("No");


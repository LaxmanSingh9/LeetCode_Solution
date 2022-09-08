class Solution {
    public int lcs(String text1 ,String text2,int i,int j,int len,int [][]memo){
        if(i>=text1.length() || j>=text2.length())
            return text2.length()==len?1:0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        int a=0,b=0,c=0;
        if(text1.charAt(i)==text2.charAt(j)){
            a=lcs(text1,text2,i+1,j+1,len+1,memo);
            b=lcs(text1,text2,i+1,j,len,memo);
            memo[i][j]=a+b;
        }
        else{
            memo[i][j]=lcs(text1,text2,i+1,j,len,memo);    
        }
       
        return memo[i][j];
    }
    public int numDistinct(String s, String t) {
        int [][]memo=new int[s.length()+1][t.length()+1];
         for(int []ar:memo){
            Arrays.fill(ar,-1);  
         } 
        
        return lcs(s,t,0,0,0,memo);
    }
}
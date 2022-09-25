class Solution {
    public int  replaceChar(int[]dp){
        int sum=0,max=0;
        for(int i=0;i<dp.length;i++){
           sum+=dp[i];
           max=Math.max(max,dp[i]);
        }
        return sum-max;
         
    }
    public int characterReplacement(String s, int k) {
        if(k>=s.length())
           return s.length(); 
        int i=0,j=0,lsr=0;
        int []map=new int[26];
        while(j<s.length()){
            map[s.charAt(j)-'A']+=1;
            while(replaceChar(map)>k){
                map[s.charAt(i)-'A']-=1;
                i+=1;
            }
            j+=1;
            lsr=Math.max(j-i,lsr);
          
        }
        return lsr;
        
    }
}
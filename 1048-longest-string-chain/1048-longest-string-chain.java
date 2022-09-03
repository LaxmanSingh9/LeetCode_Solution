class Solution {
    public boolean isPredecessor(String s1,String s2){
        if(s1.length()-s2.length()!=1)
            return false;
        for(int i=0;i<s1.length();i++){
            StringBuilder sb=new StringBuilder(s1);
            if(sb.deleteCharAt(i).toString().equals(s2))
                return true;
        }
        return false;
    }    
    public int longestStrChain(String[] words) {
        int n=words.length,longestChain=0;
        int []dp=new int[n];
        Arrays.sort(words,(s1,s2)->{
            return s1.length()-s2.length();});
        for(int i=0;i<n;i++){
           dp[i]=1; 
           for(int j=i-1;j>=0;j--){
               if(words[i].length()-words[j].length()>1)
                    break;
               if(isPredecessor(words[i],words[j]))
                   dp[i]=Math.max(dp[i],dp[j]+1);
           }
           longestChain=Math.max(longestChain,dp[i]);
        }
        return longestChain;
    }
}
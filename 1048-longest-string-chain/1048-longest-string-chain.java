class Solution {
    public boolean isPredecessor(String s1,String s2){
        if(s1.length()-s2.length()!=1)
            return false;
        char []chr=s1.toCharArray();
        for(int i=0;i<chr.length;i++){
            String s1_1="";
            if(i==0)
                s1_1=new String(Arrays.copyOfRange(chr,1,chr.length));
            if(i==chr.length-1)
                s1_1= new String(Arrays.copyOfRange(chr,0,chr.length-1));
            else
               s1_1=new String(Arrays.copyOfRange(chr,0,i))+ new String(Arrays.copyOfRange(chr,i+1,chr.length));
            if(s1_1.equals(s2))
               return true; 
        }
        return false; 
    }
    public int longestStrChain(String[] words) {
        int n=words.length,longestChain=0;
        int []dp=new int[n];
        Arrays.sort(words,(s1,s2)->{
            return s1.length()-s2.length();});
        //System.out.println(Arrays.toString(words));
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
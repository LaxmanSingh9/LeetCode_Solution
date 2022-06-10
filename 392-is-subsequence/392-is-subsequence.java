class Solution {
 public boolean isSubsequence(String s, String t) {
        int n=s.length();int m=t.length();
        int j=0;
        for(int i=0;i<m;i+=1){
            if(j<n&&s.charAt(j)==t.charAt(i)){
                j+=1;
            }
        }
        return j==n;
        
    }
    
    
}
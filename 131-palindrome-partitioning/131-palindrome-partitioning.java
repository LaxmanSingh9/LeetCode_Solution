class Solution {
    public List<List<String>>ans=new ArrayList<>();
    public void solve(String s,int st,int e,List<String>list,boolean [][]dp){
        //base case
        if(e-st==0){
            ans.add(new ArrayList<>(list));
        }
        for(int i=st;i<e;i++){
            if(dp[st][i]) {
                list.add(s.substring(st,i+1));
                solve(s,i+1,e,list,dp);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        boolean dp[][]=new boolean[s.length()+1][s.length()+1];
         for(int i=0;i<s.length();i++){//end
           for(int j=0;j<=i;j++){//start
               if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])) {
                   dp[j][i]=true;
               }
           } 
        }
        solve(s,0,s.length(),new ArrayList<>(),dp);
        return ans;
    }
}
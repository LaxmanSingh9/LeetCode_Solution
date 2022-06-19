class Solution {
     /*
      Suffix array and prefix array problem
     */
     public int numSplits(String s) {
        int[]memo=new int[s.length()];
        int ans=0;int n=s.length();
        Set<Character> set=new HashSet<>();
        for(int i=n-1;i>=0;i-=1){
            set.add(s.charAt(i));
            memo[i]=set.size();
        }
        set.clear();
        for(int i=0;i<n;i+=1){
            set.add(s.charAt(i));
            if(i+1!=n && set.size()==memo[i+1]){
                ans+=1;
            }
        }
        return ans;
    }
}
class Solution {
     public int numSplits(String s) {
        int[]memo=new int[s.length()];
        int []memo1=new int[s.length()];
        int ans=0;int n=s.length();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;i+=1){
            set.add(s.charAt(i));
            memo[i]=set.size();
        }
       set=new HashSet<>();
        for(int i=n-1;i>=0;i-=1){
            set.add(s.charAt(i));
            memo1[i]=set.size();
        }
         // System.out.println(Arrays.toString(memo));
         //  System.out.println(Arrays.toString(memo1));
        for(int i=0;i<n;i+=1){
            if(i+1!=n  &&  memo[i]==memo1[i+1]){
                ans+=1;
            }
        }
        return ans;
    }
}
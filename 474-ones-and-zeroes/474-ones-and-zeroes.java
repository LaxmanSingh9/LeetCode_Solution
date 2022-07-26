class Solution {
    public int solve(String[] s,int i ,List<Integer>list,int m,int n,int[][][]memo){
        if(m<0 || n<0 || i>=s.length){
            return (m<0||n<0)?-1:0;
        }
        if(memo[i][m][n]!=-1){
            return memo[i][m][n];
        }
        int[] arrofZerosAndOnes=cal(s[i],m,n);
        int zeros=arrofZerosAndOnes[0],ones=arrofZerosAndOnes[1];
        int ans1=solve(s,i+1,list,m-zeros,n-ones,memo)+1;
        int ans2=solve(s,i+1,list,m,n,memo);
        memo[i][m][n]= Math.max(ans1,ans2);
        return  memo[i][m][n];
        
        
    }
    public int[] cal(String s,int m,int n){
        Map<String,Integer>map=new HashMap<>();
        int totalZeros=0,totalOnes=0;
        for(char c:s.toCharArray()){
              if(c=='0')
                 map.put("0",map.getOrDefault("0",0)+1);
              else
                 map.put("1",map.getOrDefault("1",0)+1);
           }
        totalZeros=map.getOrDefault("0",0);
        totalOnes=map.getOrDefault("1",0);
        int ans[]=new int[2];
        ans[0]=totalZeros;ans[1]=totalOnes;
        return ans;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int [][][]memo=new int[len+1][m+1][n+1];
        for(int [][]ar:memo){
            for(int []a:ar)
              Arrays.fill(a,-1);
        }
        return solve(strs,0,new ArrayList<>(),m,n,memo);
    }
}
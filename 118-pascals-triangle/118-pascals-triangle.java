class Solution {
    public List<Integer>solve(List<Integer>list,int n){
        List<Integer>l=new ArrayList<>();
        l.add(1);
        for(int i=0;i<n;i+=1){
            if(i+1<n){
                l.add(list.get(i)+list.get(i+1));
            }
        }
        l.add(1);
        return l;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>l=new ArrayList<>();l.add(1);ans.add(l);
        for(int i=1;i<numRows;i+=1){
            ans.add(solve(ans.get(i-1),i));
        }
        return ans;
    }
}
class Solution {
   public int lengthOfLIS(int[] nums) {
        int n=nums.length,ans=1,LISIndex=0;
        int[]dp=new int[n];Arrays.fill(dp,1);
        List<List<Integer>>lis=new ArrayList<>();
        for(int i=0;i<n;i+=1)
          lis.add(new ArrayList<>());
        for(int i=0;i<n;i+=1){
          for(int j=i;j>=0;j-=1){
            if(nums[i]>nums[j] && lis.get(j).size()>lis.get(i).size())
               lis.set(i,new ArrayList<>(lis.get(j)));
            }
          lis.get(i).add(nums[i]);
          if(ans<lis.get(i).size()){
             LISIndex=i;ans=lis.get(i).size();
          }
           
        }
        return lis.get(LISIndex).size();    
    }
}
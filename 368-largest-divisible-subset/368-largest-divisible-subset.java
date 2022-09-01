class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length,maxLis=0,index=-1;
        int []lis=new int[n],prev=new int[n];
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
           lis[i]=1;
           prev[i]=-1; 
           for(int j=i-1;j>=0;j--){
               if(nums[i]%nums[j]==0 && lis[i]<lis[j]+1){
                   lis[i]=lis[j]+1;
                   prev[i]=j;
               }
           }
           if(lis[i]>maxLis){
               maxLis=lis[i];
               index=i;
           }
       }
       ArrayList<Integer>res=new ArrayList<>(); 
       while(index!=-1){
          res.add(nums[index]);
          index=prev[index];
       } 
       return res; 
        
    }
}
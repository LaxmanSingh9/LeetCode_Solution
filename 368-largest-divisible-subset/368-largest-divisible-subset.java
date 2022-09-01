class Solution {
    private List<Integer>getOrderedLIS(List<Integer>listOfMaxLIS,Map<Integer,Integer>map){
       ArrayList<ArrayList<Integer>>arList=new ArrayList<>();
       for(int val:listOfMaxLIS){
           ArrayList<Integer>ar=new ArrayList<>();
           ar.add(val);ar.add(map.get(val));
           arList.add(ar);
       }
       Collections.sort(arList,(l1, l2) -> {
         if(l1.get(0) > l2.get(0))
            return 1;
         else if(l1.get(0) < l2.get(0))
           return -1;
         else
           return 0;
       });
       List<Integer>orderedLIS=new ArrayList<>();
       for(List<Integer>ar:arList){
           orderedLIS.add(ar.get(0));
       } 
       return orderedLIS;
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length,ans=0,indxWOfMaxLIS=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
             map.put(nums[i],i);    
        }
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>>listOfAllSub=new ArrayList<>();
        for(int i=0;i<n;i++){
            listOfAllSub.add(new ArrayList<>());
            //listOfAllSub.get(i).add(nums[i]);
        }
        
        for(int i=0;i<n;i++){
          ArrayList<Integer>ar=new ArrayList<>(listOfAllSub.get(i));
          for(int j=i-1;j>=0;j--){
              if(nums[i]%nums[j]==0 && ar.size()<=listOfAllSub.get(j).size()){
                  ar=new ArrayList<>(listOfAllSub.get(j));
               }
          }
       
          ar.add(nums[i]);  
          listOfAllSub.get(i).addAll(ar);
          if(listOfAllSub.get(i).size()>ans){
             ans=listOfAllSub.get(i).size();
             indxWOfMaxLIS=i; 
          }
       }
       
       return getOrderedLIS(listOfAllSub.get(indxWOfMaxLIS),map);
    }
}
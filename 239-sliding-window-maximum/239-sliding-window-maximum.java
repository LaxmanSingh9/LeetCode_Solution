class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Map<Integer,Integer>count=new HashMap<>();
       PriorityQueue<Integer> pq =new PriorityQueue<>((x, y) -> Integer.compare(y, x)); 
       int []res=new int[nums.length-k+1]; 
       int i=0; 
       for(int j=0;j<nums.length;j++){
         count.put(nums[j],count.getOrDefault(nums[j],0)+1);
         pq.add(nums[j]);  
         if(j-i+1==k){
            res[i]=pq.peek();
            count.put(nums[i],count.get(nums[i])-1);
            count.remove(nums[i],0);
            while(!count.containsKey(pq.peek()) && pq.size()>0)
               pq.poll();
            i++; 
        }  
       }  
       return res; 
        
    }
}
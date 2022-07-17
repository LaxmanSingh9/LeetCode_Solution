class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0,i=0,n=nums.length;
        Queue<Integer>queue=new LinkedList<>();
        for(int j=0;j<n;j+=1){
           if(nums[j]==0)queue.add(j);
           if(queue.size()==k+1)i=queue.poll()+1;
           ans=Math.max(ans,j-i+1);
        }
        return ans;  
    }
        
    }

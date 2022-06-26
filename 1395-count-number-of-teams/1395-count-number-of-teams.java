class Solution {
    //brute force approch O(n^2)
   //lesser*greter=>
   //greater*lesser
    public int numTeams(int[] ratings) {
        int ans=0;int n=ratings.length;
        for(int i=0;i<n;i+=1){
           int lesser[]=new int[2];int greater[]=new int[2];
           for(int j=0;j<n;j+=1){
               if(ratings[i]<ratings[j]){
                   ++greater[i<j?1:0];
                }
                if(ratings[i]>ratings[j]){
                    ++lesser[i<j?1:0];
                }
           }
           ans+=lesser[0]*greater[1]+greater[0]*lesser[1];
            
        }
       
        return ans;
        
    }
}
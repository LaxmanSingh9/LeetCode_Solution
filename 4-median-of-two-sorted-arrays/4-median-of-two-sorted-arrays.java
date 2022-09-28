class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        int x=nums1.length,y=nums2.length;
        int st=0,end=nums1.length;
        while(st<=end){
            int posX=(st+end)/2;
            int posY=(x+y+1)/2-posX;
            
            int maxX=posX==x?Integer.MAX_VALUE:nums1[posX];
            int minX=posX<=0?Integer.MIN_VALUE:nums1[posX-1];
            //For nums2
            int maxY=posY==y?Integer.MAX_VALUE:nums2[posY];
            int minY=posY<=0?Integer.MIN_VALUE:nums2[posY-1];
            
            if(minY<=maxX && minX<=maxY){
                 if ((x + y) % 2 == 0) {
                    return ((double)Math.max(minX,minY) + Math.min(maxX,maxY))/2;
                } else {
                   return Math.max(minX,minY);
                }
            }
            else if(minX>=maxY) end=posX-1;
            else  st=posX+1;
       }
       return -1; 
        
        
    }
}
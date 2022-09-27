class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        double firstEle=0,secondEle=0;
        int i=0,j=0,k=0,tot_len=n1+n2;
        while(i<tot_len && j<n1 && k<n2){
            // System.out.println(i+" "+j+" "+k);
            while(j<n1 && k<n2 && nums1[j]>=nums2[k]){
                if(i==(tot_len-1)/2)firstEle=nums2[k];
                if(i==(tot_len+1)/2)secondEle=nums2[k];   
                k++;i++;
            }
            while(j<n1&& k<n2 && nums1[j]<=nums2[k]){
                if(i==(tot_len-1)/2)firstEle=nums1[j];
                if(i==(tot_len+1)/2)secondEle=nums1[j];   
                j++;i++;
            }
        }
        while(j<n1){
            if(i==(tot_len-1)/2)firstEle=nums1[j];
            if(i==(tot_len+1)/2)secondEle=nums1[j];   
            j++;i++;
        } 
        while(k<n2){
            if(i==(tot_len-1)/2)firstEle=nums2[k];
            if(i==(tot_len+1)/2)secondEle=nums2[k];   
            k++;i++;
        } 
        System.out.println(firstEle+" "+secondEle);
        return tot_len%2==1?firstEle:(firstEle+secondEle)/2;
                   
        
    }
}
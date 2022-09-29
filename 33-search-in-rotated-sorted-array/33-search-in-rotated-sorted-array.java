class Solution {
    public int pivot(int []nums,int val,int st,int end){
        if(end<=st)
          return  end;
        int mid=(end+st)/2;
        if(val<=nums[mid])return pivot(nums,val,mid+1,end);
        else return pivot(nums,val,st,mid-1);
    }
    int binarySearch(int arr[], int l, int r, int x){
        if(r>=l){
            int mid = l + (r - l) / 2;
            if (arr[mid]==x)return mid;
            if (arr[mid]>x)return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    public int search(int[] nums, int target) {
       int k=pivot(nums,nums[0],0,nums.length-1);
       if(k+1<nums.length && nums[k]>nums[k+1])k+=1;
       int a=binarySearch(nums,k,nums.length-1,target);
       if(a!=-1)return a;
       int b=binarySearch(nums,0,k,target);
       return b; 
    }
}
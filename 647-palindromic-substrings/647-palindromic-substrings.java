import java.util.*;
class Solution {
    public int countSubstrings(String s) {
       int totalPalindromeSubstrings=0,j=0,k=0;
       int n=s.length();
       char []arr=s.toCharArray();
       for(int i=0;i<n;i+=1){  //This for odd length substring
           j=i;k=i;
           while(j>=0 && k<n && arr[j]==arr[k]){
               totalPalindromeSubstrings+=1;j-=1;k+=1;
           }
       }
       for(int i=0;i<n;i+=1){  //This for even length substring
           j=i;k=i+1;
           while(j>=0 && k<n && arr[j]==arr[k]){
               totalPalindromeSubstrings+=1;j-=1;k+=1;

           }
       }
       return totalPalindromeSubstrings;
    }
}
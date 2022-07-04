import java.util.*;
class Solution {
    public int minDeletions(String s) {
        int []freq=new int[26];
        int n=s.length(),ans=0;
        for(int i=0;i<n;i+=1){
            freq[s.charAt(i) - 'a'] += 1;
        }
        Arrays.sort(freq);
        List<Integer>freq2=new ArrayList<>();
       // System.out.println(Arrays.toString(freq));
        int currFreq=0,prevFreq=0;
        for(int i=25;i>=0&&freq[i]!=0;i-=1){
            currFreq=freq[i];
            if(freq2.contains(freq[i])){
                if(freq2.contains(1)){
                   for(int j=i;j>=0;j-=1)ans+=freq[j];
                   break;
                }
                else{
                   currFreq=prevFreq-1;
                   ans+=freq[i]-currFreq;
                }
            }
            freq2.add(currFreq);
            prevFreq=currFreq;
            
        } 
        return ans;
    }
}
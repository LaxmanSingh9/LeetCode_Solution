import java.util.*;
class Solution {
    public int minDeletions(String s) {
        int []freq=new int[26];
        int n=s.length(),ans=0;
        for(int i=0;i<n;i+=1){
            freq[s.charAt(i) - 'a'] += 1;
        }
        Arrays.sort(freq);
        Map<Integer,Integer>map=new HashMap<>();
        int currFreq=0,prevFreq=0;
        for(int i=25;i>=0&&freq[i]!=0;i-=1){
            currFreq=freq[i];
            if(map.containsKey(freq[i])){
                if(map.containsKey(1)){
                   for(int j=i;j>=0;j-=1)ans+=freq[j];
                   break;
                }
                else{
                   currFreq=prevFreq-1;
                   ans+=freq[i]-currFreq;
                }
            }
            map.put(currFreq,1);
            prevFreq=currFreq;
            
        } 
        return ans;
    }
}
import java.util.*;
class Solution {
    public int minDeletions(String s) {
        int []freq=new int[26];
        int n=s.length(),ans=0;
        for(int i=0;i<n;i+=1){
            freq[s.charAt(i) - 'a'] += 1;
        }
        Map<Integer,Integer>map=new HashMap<>();
        int currFreq=0,prevFreq=0;
        for(int i=25;i>=0;i-=1){
            currFreq=freq[i];
            while(map.containsKey(currFreq)){
                currFreq-=1;
            }
            if(currFreq<=0){ans+=freq[i];continue;}
            map.put(currFreq,1);
            ans+=freq[i]-currFreq;
        } 
        return ans;
    }
}
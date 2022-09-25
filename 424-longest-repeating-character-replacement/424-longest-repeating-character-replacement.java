class Solution {
   public int characterReplacement(String s, int k) {
        if(k>=s.length())
           return s.length(); 
        int []freq=new int[26];
        int st=0,lsr=0,maxCnt=0;
        for(int end=0;end<s.length();end++){
            maxCnt=Math.max(maxCnt,++freq[s.charAt(end)-'A']);
            while(end-st+1-maxCnt>k){
                freq[s.charAt(st)-'A']-=1;
                st+=1;
            }
            lsr=Math.max(end-st+1,lsr);
        }
        return lsr;
        
    }
}
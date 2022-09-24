class Solution {
    public boolean hasSameFreq(int[]ar1,int[]ar2){
       for(int i=0;i<ar1.length;i++)
           if(ar1[i]!=ar2[i])return false;
        return true;
    } 
    public List<Integer> findAnagrams(String s, String p) {
       int pLen=p.length(),sLen=s.length();List<Integer>allAnagStIdx=new ArrayList<>();
       int []freqP=new int[26]; int []freqS=new int[26];
       for(char ch:p.toCharArray())freqP[ch-97]+=1;
       int st=0,end=0;
       for(int i=0;i<sLen;i++){
           freqS[s.charAt(i)-97]+=1;
           if(end-st+1==pLen) {
               if(hasSameFreq(freqS,freqP))allAnagStIdx.add(st);
               freqS[s.charAt(st)-97]-=1;
               st+=1;
           }
           end+=1;
       } 
       return  allAnagStIdx;
    }
}
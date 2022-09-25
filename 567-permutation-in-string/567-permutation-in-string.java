class Solution {
    public boolean hasSameFreq(int[]ar1,int []ar2){
       for(int i=0;i<ar1.length;i++){
          if(ar1[i]!=ar2[i])
             return  false;
       }
       return true; 
    }
    public boolean checkInclusion(String s1, String s2) {
       int []s1Freq=new int[26];
       int []s2Freq=new  int[26];
       for(char ch:s1.toCharArray())
          s1Freq[ch-'a']+=1; 
       int st=0; 
       for(int e=0;e<s2.length();e++){
           char ch=s2.charAt(e);
           s2Freq[ch-'a']+=1;
           if(e-st+1==s1.length()){
               if(hasSameFreq(s1Freq,s2Freq))
                  return true;
               s2Freq[s2.charAt(st)-'a']-=1;
               st+=1; 
           } 
       } 
       return false; 
        
       //will need to find an substring which has sames chars as s1 has
       //run an loop as long as find an sub string of lenght s1 comapre the char freq of both string
       //TC O(n)
       //SC(2*26) 
    }
}
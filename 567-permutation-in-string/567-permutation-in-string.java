class Solution {
    public boolean hasAllZeros(int[]ar1){
       for(int i=0;i<ar1.length;i++){
          if(ar1[i]!=0)
             return  false;
       }
       return true; 
    }
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length()>s2.length())
          return false; 
       int []freq=new int[26];
       for(int i=0;i<s1.length();i++) {
           freq[s1.charAt(i)-'a']++;freq[s2.charAt(i)-'a']--;
       }
       if(hasAllZeros(freq))
          return true; 
       for(int e=s1.length();e<s2.length();e++){
           freq[s2.charAt(e)-'a']--;
           freq[s2.charAt(e-s1.length())-'a']++;
           if(hasAllZeros(freq))
              return true; 
       } 
       return false;
    }
}
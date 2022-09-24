class Solution {
    public boolean isAllCharUnique(Map<Character,Integer>map){
        int uniq=0;
        for(char ch:map.keySet()){
            if(map.get(ch)>0) uniq+=1; 
        }
        return uniq==3?true:false;
    }
    public int countGoodSubstrings(String s) {
       int i=0,j=0,ans=0,subLen=3;
       Map<Character,Integer>map=new HashMap<>(); 
       while(j<s.length()){
           char ch=s.charAt(j); 
           map.put(ch,map.getOrDefault(ch,0)+1);
           if(j-i+1==subLen){
               ans+=isAllCharUnique(map)?1:0;ch=s.charAt(i);
               map.put(ch,map.get(ch)-1); 
               if(map.get(ch)==0)map.remove(ch);
               i+=1;
           }
           j+=1;
       }
       return ans; 
        
    }
}
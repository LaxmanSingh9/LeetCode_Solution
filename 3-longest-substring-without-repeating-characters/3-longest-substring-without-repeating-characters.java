class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int ans=0,lss=0,stIndex=-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.get(ch)!=null && map.get(ch)>stIndex){
               lss=i-map.get(ch);stIndex=map.get(ch);
            }
            else{
                lss+=1;
            }
            map.put(ch,i);
            ans=Math.max(ans,lss);
        }
        return ans;
        
    }
}
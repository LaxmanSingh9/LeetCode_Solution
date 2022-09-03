class Solution {
   public int longestStrChain(String[] words) {
        int n=words.length,longestChain=0;
        Arrays.sort(words,(s1,s2)->{return s1.length()-s2.length();});
        Map<String,Integer>map=new HashMap<>();
        for(String str:words){
           map.put(str,1); 
           for(int i=0;i<str.length();i++){
            StringBuilder sb=new StringBuilder(str);
            String oneCharDiffStr=sb.deleteCharAt(i).toString();
            if(map.containsKey(oneCharDiffStr) && map.get(oneCharDiffStr)+1>map.get(str))   
                map.put(str,map.get(oneCharDiffStr)+1);
           }
           longestChain=Math.max(longestChain,map.get(str));
        }
        return longestChain;
    }
}
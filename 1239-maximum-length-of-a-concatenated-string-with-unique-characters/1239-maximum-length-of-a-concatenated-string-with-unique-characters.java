class Solution {
    public int isValidConcat(String s){
        int []freq=new int[26];
        for(int i=0;i<s.length();i+=1){
            freq[s.charAt(i)-'a']+=1;
            if(freq[s.charAt(i)-'a']>1)
             return 0;
        }
        return s.length();
    }
    public Map<String,Integer>map=new HashMap<>();
    public int solve(List<String> arr,int i ,String s){
        if(i==arr.size()){   
            
          return isValidConcat(s);
        }
        if(map.containsKey(s))
            return map.get(s);
        map.put(s,Math.max(solve(arr,i+1,s+arr.get(i)),solve(arr,i+1,s)));
        return map.get(s);
        
    }
    public int maxLength(List<String> arr) {
        
        return solve(arr,0,"");
    }
}
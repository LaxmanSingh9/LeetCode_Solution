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
    public int solve(List<String> arr,int i ,String s){
        if(s!="" && isValidConcat(s)==0){
            return 0;
        }
        if(i==arr.size()){   
            return s.length();
        }
        
        return Math.max(solve(arr,i+1,s+arr.get(i)),solve(arr,i+1,s));
    }
    public int maxLength(List<String> arr) {
        return solve(arr,0,"");
    }
}
class Solution {
    public int solve(int places,int letterNum){
        if(places==0){
            return 1;
        }
        if(letterNum==0){
            return 0;
        }
        return solve(places-1,letterNum)+solve(places,letterNum-1);
        
    }
    
        
    public int countVowelStrings(int n) {
        return solve(n,5);
    }
}
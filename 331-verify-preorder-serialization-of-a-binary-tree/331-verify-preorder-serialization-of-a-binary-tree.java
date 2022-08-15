class Solution {
    public boolean isValidSerialization(String preorder) {
        Integer diff=1;
        for(String currChar:preorder.split(",")){
            diff-=1;
            if(diff<0)
              return false;
            if(!currChar.equals("#"))
               diff+=2;
            
        }
        return diff==0;
        
    }
}
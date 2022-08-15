class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String>stack=new Stack<>();
        for(String currChar:preorder.split(",")) {
            while(currChar.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(currChar);
        }
        return stack.size()==1 && stack.peek().equals("#");
        
    }
}
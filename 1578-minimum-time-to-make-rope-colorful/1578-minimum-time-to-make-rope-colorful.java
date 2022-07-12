class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> stack = new Stack<Integer>();
        int i=0,ans=0,n=neededTime.length;
        while(i!=n){
            if(i==0)stack.push(i);
            else if(stack.size()>0 && colors.charAt(stack.peek())==colors.charAt(i)){
                 if(neededTime[stack.peek()]<neededTime[i]){
                       ans+=neededTime[stack.pop()];stack.add(i);
                  }
                  else{
                      ans+=neededTime[i];
                  }
            }
            else stack.push(i);
            i+=1;
        }
        return ans;
    }
}
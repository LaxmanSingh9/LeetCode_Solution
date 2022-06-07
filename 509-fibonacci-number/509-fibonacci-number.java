class Solution {
    public int sumOfNumber(int n){
        int sum=0;
        for(int i=0;i<n;i+=1){
            sum+=i;
        }
        return sum;
    }
    public int fib(int n) {
        if(n==0){
           return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
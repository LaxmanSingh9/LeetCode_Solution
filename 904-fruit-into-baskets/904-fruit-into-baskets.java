class Solution {
    public int totalFruit(int[] fruits){
       if(fruits.length==1)
           return fruits.length;
       List<Integer>toDel;
       Map<Integer,Integer>freq=new HashMap<>(); 
       int maxPick=0,i=0; 
       for(int j=0;j<fruits.length;j++){
           freq.put(fruits[j],freq.getOrDefault(fruits[j],0)+1);
           if(freq.size()>2){
              while(freq.size()>2){
                 freq.put(fruits[i],freq.get(fruits[i])-1);
                 freq.remove(fruits[i],0);
                 i+=1;
              }
           }
           maxPick=Math.max(j-i+1,maxPick);
       }
       return maxPick; 
    }
}
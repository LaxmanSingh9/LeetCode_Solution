class Solution {
    public int totalFruit(int[] fruits){
       if(fruits.length==1)
           return fruits.length;
       int[]unqiueNess=new int[fruits.length];
       List<Integer>toDel;
       Map<Integer,Integer>map=new HashMap<>(); 
       int maxPick=0,i=0; 
       for(int j=0;j<fruits.length;j++){
           int val=fruits[j];
           map.put(val,map.getOrDefault(val,0)+1);
           if(map.size()>2){
              toDel=new ArrayList<>(); 
              while(map.size()-toDel.size()>2){
                 map.put(fruits[i],map.get(fruits[i])-1);
                 if(map.get(fruits[i])==0)toDel.add(fruits[i]);
                 i+=1;
              }
              for(int v:toDel)map.remove(v);
           }
           maxPick=Math.max(j-i+1,maxPick);
       }
       return maxPick; 
        
    }
}
class Solution {
    Set<int[]> visited=new HashSet<>();
    public void dfs(int[][]arr,int []stone){
        visited.add(stone);
        for(int []ar:arr){
            int newU=ar[0],newV=ar[1];
            if((stone[0]==newU || stone[1]==newV) && visited.contains(ar)==false) {
                dfs(arr,ar);
            }
        }
    }
    public int removeStones(int[][] stones) {
      int remainStones=0;
      for(int []stone:stones){
          int x=stone[0],y=stone[1];
          if(visited.contains(stone)==false){
             dfs(stones,stone);
             remainStones+=1;
          }
      }
      return stones.length-remainStones; 
         
    }
}
class Solution {
    
    // There are two cases
    //   1.Non-null->edge count should be decrease by one & increase by two
    //   2.Null Node->edge count should be decrease by one & no increase
    //   If after all the opeations if edge==0 ,tree would be serilized
    public boolean isValidSerialization(String preorder) {
          String nodes[]=preorder.split(",");
          int edgeCount=1;
          for(String node:nodes){
              
              edgeCount-=1;
              if(edgeCount<0){
                  return false;
              }
              if(!(node.equals("#"))){
                  edgeCount+=2;
              }
          }
          return edgeCount==0;
        
    }
}
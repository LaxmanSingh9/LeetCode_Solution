class Solution {
    public void dfs(char[][]board,Integer rowN,Integer colN){
        if((rowN<=0 || rowN>=board.length-1) || (colN<=0 || colN>=board[0].length-1) || board[rowN][colN]!='O')
            return;
        board[rowN][colN]='X';
        dfs(board,rowN+1,colN);
        dfs(board,rowN-1,colN);
        dfs(board,rowN,colN+1);
        dfs(board,rowN,colN-1);
    }
    public boolean isValidRegion(char[][]board,Integer rowN,Integer colN,int[][]vis){
        if((rowN<=0 || rowN>=board.length-1 || colN<=0 || colN>=board[0].length-1) && board[rowN][colN]=='O'){
           return false;
        }
           
        if(rowN<0 || rowN>board.length || colN<0 || colN>board[0].length || board[rowN][colN]!='O')
            return true;
        if(vis[rowN][colN]==1){
           return true; 
        }
           
        vis[rowN][colN]=1;
        boolean op1=isValidRegion(board,rowN+1,colN,vis);
        boolean op2=isValidRegion(board,rowN-1,colN,vis);
        boolean op3=isValidRegion(board,rowN,colN+1,vis);
        boolean op4=isValidRegion(board,rowN,colN-1,vis);
        boolean ans=op1&op2&op3&op4;
        return ans;
    }
    public void solve(char[][] board) {
        int [][]visited=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i+=1){
            for(int j=0;j<board[0].length;j+=1){
               if(board[i][j]=='O' && visited[i][j]==0 && isValidRegion(board,i,j,visited)) 
                    dfs(board,i,j);
            }
        }
    }
}
class Solution {
    public void dfs(char[][]board,Integer rowN,Integer colN){
        if((rowN<0 || rowN>=board.length) || (colN<0 || colN>=board[0].length) || board[rowN][colN]!='O')
            return;
        board[rowN][colN]='*';
        dfs(board,rowN+1,colN);
        dfs(board,rowN-1,colN);
        dfs(board,rowN,colN+1);
        dfs(board,rowN,colN-1);
    }
    public void solve(char[][] board) {
        int row=board.length,col=board[0].length;
        for(int i=0;i<col;i++){
            if(board[0][i]=='O')
                dfs(board,0,i);
            if(board[row-1][i]=='O')
               dfs(board,row-1,i);
        }
        for(int i=0;i<row;i++){
            if(board[i][0]=='O')
                dfs(board,i,0);
            if(board[i][col-1]=='O')
                dfs(board,i,col-1);
        }
        for(int i=0;i<board.length;i+=1){
            for(int j=0;j<board[0].length;j+=1){
              if(board[i][j]=='O')
                 board[i][j]='X';
              if(board[i][j]=='*')
                 board[i][j]='O';
                  
            }
        }
    }
}
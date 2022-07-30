class Solution {
    int ans=Integer.MAX_VALUE; 
    public void solve(int []tasks,int sessionTime,int start,int[]sessions,int sessionCount){
        if(start>=tasks.length){
            ans=Math.min(ans,sessionCount);
            return ;
        }
        if(sessionCount>=ans){
            return;
        }
        for(int i=0;i<sessionCount;i+=1){
            if(sessions[i]+tasks[start]<=sessionTime){
                sessions[i]+=tasks[start];
                solve(tasks,sessionTime,start+1,sessions,sessionCount);
                sessions[i]-=tasks[start];
            }
        }
        sessions[sessionCount]=tasks[start];
        solve(tasks,sessionTime,start+1,sessions,sessionCount+1);
        sessions[sessionCount]-=tasks[start];
    }
    public int minSessions(int[] tasks, int sessionTime) {
        int []vis=new int[tasks.length];
        solve(tasks,sessionTime,0,vis,0);
        return ans;
    }
}
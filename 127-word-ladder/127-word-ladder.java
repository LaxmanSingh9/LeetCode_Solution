class Solution {
    public int bfs(String bw,String ew,List<String>wl){
        Set<String> set = new HashSet<>(wl);
        if(!set.contains(ew)) return 0;
        Queue<String>q=new LinkedList<>();
        q.add(bw);
        Set<String> vis = new HashSet<>();
        int cnt=1;
        while(!q.isEmpty()){
           int si=q.size();
           for(int l=0;l<si;l+=1){
              String word=q.poll();
              if(word.equals(ew)){
                  return cnt;
              }
              for(int i=0;i<word.length();i+=1){
                 for(int j=0;j<26;j+=1){
                     char arr[] = word.toCharArray();
                     arr[i] = (char) (j+97);
                     String str = new String(arr);
                     if(set.contains(str) && !vis.contains(str)){
                         q.add(str);
                         vis.add(str);
                     }
                     
                 }
              }
               
           }
           cnt+=1;
       }
       return 0; 
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       return bfs(beginWord,endWord,wordList);   
    }
}
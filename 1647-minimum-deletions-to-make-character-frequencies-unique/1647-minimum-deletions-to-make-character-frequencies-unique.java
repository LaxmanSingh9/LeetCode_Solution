class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer>map=new HashMap<>();
        int n=s.length(),ans=0;
        for(int i=0;i<n;i+=1){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        List<Integer>freq=new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
              freq.add(entry.getValue());
        }
        Collections.sort(freq, Collections.reverseOrder());
        n=freq.size();
        List<Integer>freq2=new LinkedList<>();
       // System.out.println(freq.toString());
        for(int i=0;i<n;i+=1){
            if(freq2.contains(freq.get(i))){
                if(freq2.contains(1)){
                   for(int j=i;j<n;j+=1)ans+=freq.get(j);
                   break;
                }
                else{
                   int prev=freq.get(i);
                   freq.set(i,freq.get(i-1)-1);
                   ans+=prev-freq.get(i);
                }
            }
            freq2.add(freq.get(i));
        }
      //   System.out.println(freq.toString());
        return ans;
        
        
        
    }
}
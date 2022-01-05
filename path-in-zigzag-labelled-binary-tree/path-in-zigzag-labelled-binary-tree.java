class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new LinkedList<>();
        if(label <= 0)
            return result;
        int level = 1;
        while(Math.pow(2, level) - 1 < label)   level++;        
        level--; // calculate the depth, 0 indexed, 0 is odd
        while(level != 0) {
            result.add(0, label);
            int min=(int)Math.pow(2,level);
            int max=(int)Math.pow(2,level+1)-1;
            int pos=max-label;
            pos=min+pos;
            label=pos/2;
            level-=1;
        }
        result.add(0, 1);
        return result;
    } }
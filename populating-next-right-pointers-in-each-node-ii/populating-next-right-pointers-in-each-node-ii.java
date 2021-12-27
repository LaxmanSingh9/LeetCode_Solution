/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    
    public void solution(Node root){
        if(root==null){return;}
        Queue<Node>queue=new LinkedList<Node>();
        queue.add(root);
        while(queue.isEmpty()==false){
            int count=queue.size();
            List<Node>list=new ArrayList<>();
            for(int i=0;i<count;i++){
                Node node=queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                    list.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    list.add(node.right);
                }
            }
            //System.out.println(list.size());
            list.add(null);
            for(int i=1;i<list.size();i+=1){
               list.get(i-1).next=list.get(i);
             }
        }
        
        
        
        
    }
    public Node connect(Node root) {
        solution(root);
        return root;
    }
}
























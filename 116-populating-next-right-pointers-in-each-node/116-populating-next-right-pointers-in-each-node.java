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
    public Node connect(Node root) {
       if(root==null)
           return root;
       Queue<Node>queue=new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()){
           int width=queue.size();
           Node prevNode=null;
           for(int i=0;i<width;i+=1){
               Node node=queue.poll();
               if(node.left!=null)
                  queue.add(node.left);
               if(node.right!=null)
                   queue.add(node.right);
               if(prevNode!=null)
                  prevNode.next=node;
               prevNode=node;
                   
           }
           
       }
       return root; 
    }
}
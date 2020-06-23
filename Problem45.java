Executed in leetcode

public class Solution{
 int calValue=0,totalSum=0;
    void preOrderTraversalSum(Node node,int calValue){
        if(node==null) return;
        
        //  process  Node
        //Identify leaf and get the sum value
        if(node.left==null && node.right==null){
            totalSum+= calValue*10+node.value;
        }else{
            calValue=calValue*10+node.value;
        }
        preOrderTraversalSum(node.left,calValue);
        preOrderTraversalSum(node.right,calValue);
    }
    
    int sumOfPaths(){
        populateTree();
        preOrderTraversalSum(root,calValue);
        return totalSum;
    }
    
     Node root;
    void populateTree(){
        root= new Node(4);
        root.left= new Node(9);
        root.left.left= new Node(5);
        root.left.right= new Node(1);
        
        root.right= new Node(0);
    }
    
      class Node{
       public Node left;
        public Node right;
        int value;
        
        public Node(int val){
            value=val;
        }
                
    } 
    }

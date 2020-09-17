package Tree;

import java.util.Stack;

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Pair{
    TreeNode node;
    int sum;
    public Pair(TreeNode root,int value){
        node=root;
        sum =value;
    }
    public TreeNode getKey(){
        return node;
    }
    public int getValue(){
        return sum;
    }
}
public class Problem2 {
	
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        int cursum=0;
        int res=0;
        Stack<Pair> stk = new Stack<>();
         while(root!=null || !stk.isEmpty()){
             while(root!=null){
                 
                 stk.push(new Pair(root,cursum*10+root.val));
                 root=root.left;
             }
             if(root.left==null && root.right==null)
                 res+=root.val;
             
            TreeNode root=stk.pop();
            root=root.right;
         }
        
    }
}

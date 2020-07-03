/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Time complexity - O(n)
Space complexity- height of the tree
*/
class Solution {
    private class Pair{
        int value;
        TreeNode node;
        public Pair (TreeNode node,int value){
            this.node = node;
            this.value = value;
        }
    }
    public int sumNumbers(TreeNode root) {
        //base case
        if(root==null)
            return 0;
        
       // return sumNumbersUtilDFS(root,0);
       return  sumNumbersUtilBFS(root);
    }
    public int sumNumbersUtilDFS(TreeNode root, int value){
        //base case
        if(root == null)
            return 0;
        if(isLeaf(root))
            return value*10+ root.val;
        
        int left = sumNumbersUtilDFS(root.left, value*10+ root.val);
        int right = sumNumbersUtilDFS(root.right, value*10+ root.val);
        return left+right;
    }
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right ==null;
    }
    /*
    Time complexity - O(n)
    Space complexity- maximum width of the level
    */
    private int sumNumbersUtilBFS(TreeNode root){
        if(root == null)
            return 0;
        
        Queue<Pair> q = new LinkedList<>();
        //add node value and current value at this node which will be sent to its children/
        q.add(new Pair(root, 0));
        
        int sum=0;
        while(!q.isEmpty()){
            //queue size
            int size = q.size();
            for(int i=0; i< size; i++){
                Pair p = q.remove();
                if(isLeaf(p.node))
                    sum+= p.value *10 + p.node.val;
                else{
                    if(p.node.left != null)
                        q.add(new Pair(p.node.left, p.value *10 + p.node.val));
                    if(p.node.right != null)
                    q.add(new Pair(p.node.right, p.value *10 + p.node.val));
                } 
            }
        }
        return sum;
    }
}


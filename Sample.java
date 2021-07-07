/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // sum root to leaf members
 //Time o(n) n - no of nodes
 //space o(h) h - height of the tree
class Solution {
    class Pair{
        TreeNode root;
        int sum;
        Pair(TreeNode root, int sum){
            this.root = root;
            this.sum = sum;
        }
    }
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if(root == null)
            return res;
        Stack<Pair> stack = new Stack<>();
        int sum = 0;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                sum = sum*10 + root.val;
                stack.push(new Pair(root,sum));
                root = root.left;
            }
            Pair p = stack.pop();
            root = p.root;
            sum = p.sum;
            //leaf node
            if(root.left == null && root.right == null){
                res = res + sum;
            }
            root = root.right;
        }
        return res;
    }
}


//Need to solve the other type, Construct binary tree from inorder and postorder
//Time o(n) n - size of the array
//space - recursive stack space

class Solution {
    
    HashMap<Integer, Integer> map;
    int index = 0;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length ==0)
            return null;
        
        map = new HashMap<>();
        index = postorder.length-1;
        
        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(postorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end){
        //base case
        if(start > end || index < 0)
            return null;
        //logic
        int rootIdx = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index--;
        root.right = helper(postorder, rootIdx+1,end);
        root.left = helper(postorder, start,rootIdx-1);
        return root;
    }
}
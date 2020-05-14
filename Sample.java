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

// Construct binary tree from inorder and preorder
//time o(n)
//space o(n) , n - size of the array 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        //base case
        if(start>end || index >= preorder.length)
            return null;
        //logic
        int Ridx = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, start, Ridx-1);
        root.right = helper(preorder, Ridx+1, end);
        return root;
    }
}
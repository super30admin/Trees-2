// Time Complexity :O(N)
// Space Complexity : O(H) Height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
Iterative:
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
class Pair{
    TreeNode root;
    int sum;

    public Pair(TreeNode root, int sum ){
        this.root=root;
        this.sum=sum;
    }

    public TreeNode getKey(){
        return this.root;
    }
    public int getSum(){
        return this.sum;
    }
}
class Solution {
    //int res =0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        Stack<Pair> stack = new Stack<>();
        int currSum =0, res=0;
        while(root!=null || !stack.isEmpty()){
            //left
            while(root!=null){
                currSum = currSum * 10 +  root.val;
                stack.push(new Pair(root, currSum));
                root=root.left;
            }
            Pair pair = stack.pop();
            //root
            root = pair.getKey();
            currSum = pair.getSum();
            if(root.left==null && root.right==null){
                res = res + currSum;
            }
            //right
            root=root.right;
        }
        return res;
    }

}

-----------------------------------------------------------------------

Recursive:
class Solution {
    int rootToLeaf = 0;

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }

    public void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = currNumber * 10 + r.val;
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }
}
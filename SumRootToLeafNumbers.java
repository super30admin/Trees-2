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
 // Approach : Iterative solution
 // Time : O(n) # visiting all the nodes/ Max depth of the tree
 // Space : O(n) # depth of the tree
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        // edge case
       if(root==null) return 0;
       Stack<Pair<TreeNode,Integer>> stk = new Stack<>();
       int currSum = 0;
       while(root!=null || !stk.isEmpty()){
            while(root!=null){
                currSum=currSum*10+root.val;
                stk.push(new Pair(root,currSum));
                root = root.left;
            }
            Pair<TreeNode, Integer> p = stk.pop();
            root = p.getKey();
            currSum = p.getValue();
            // reach the leaf node
            if(root.left == null && root.right == null){
                result+=currSum;
            }
            root=root.right;
       } 
       return result;
    }
}

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
// Approach : Recursive solution with global scope
 // Time : O(n) # visiting all the nodes/ Max depth of the tree
 // Space : O(n) # depth of the tree
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        // edge case
       if(root==null) return 0;
       helper(root,0);
       return result;
    }

    public void helper(TreeNode root,Integer currSum){
        // Base case
        if(root == null) return;
        currSum = currSum*10 + root.val;
        if(root.left == null && root.right == null){
            result+=currSum;
        }
        helper(root.left,currSum);
        helper(root.right,currSum);
    }
}

// Approach : Recursive solution with local scope
 // Time : O(n) # visiting all the nodes/ Max depth of the tree
 // Space : O(n) # depth of the tree
class Solution {
    public int sumNumbers(TreeNode root) {
        // edge case
       if(root==null) return 0;
       return helper(root,0);
    }

    public int helper(TreeNode root,Integer currSum){
        // Base case
        if(root == null) return 0;

        // logic
        if(root.left == null && root.right == null){
            return currSum*10+root.val;
        }
        int left = helper(root.left,currSum*10+root.val);
        int right = helper(root.right,currSum*10+root.val);

        return left+right;
    }
}
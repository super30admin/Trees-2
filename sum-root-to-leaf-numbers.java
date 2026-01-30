// Solution -1

//TimeComplexity: O(n) n is number of nodes
//SpaceComplexity: O(h) h is height of the tree
// Explanation for both solutions : I am recursively traversing the binary tree to compute the sum of all numbers formed from root-to-leaf paths. 
// At each node, I multiply the current value by 10 and add the node’s value to form the number along that path.
//  If the node is a leaf, I either return the current number (in the first approach) or add it to a global sum variable (in the second approach). 
// The recursion continues for left and right children until all paths are processed, and the total sum of all root-to-leaf numbers is computed.

class Solution {
    public int sumNumbers(TreeNode root) {
        
        return helper(root,0);
        
        
    }

    private int helper (TreeNode root, int curr) {
        if(root == null) {
            return 0;
        }
        curr = curr*10 +root.val;
        if(root.left == null && root.right == null){
            return curr;

        }
        int left = helper(root.left, curr);
    
        int right = helper(root.right, curr);
        return left+right;
    }
}

// Solution-2

//TimeComplexity: O(n) n is number of nodes
//SpaceComplexity: O(h) h is height of the tree
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        
        helper(root,0);
        return sum;
        
    }

    private void helper (TreeNode root, int curr) {
        if(root == null) {
            return;
        }
        curr = curr*10 +root.val;
        if(root.left == null && root.right == null){
            sum+=curr;

        }

        helper(root.left, curr);
    
        helper(root.right, curr);
    }
}
//Problem 46 : Sum Root to Leaf Numbers
// Time Complexity : O(N), N stands for number of nodes
// Space Complexity : O(H), H stands for height of the tree, in worst case it can be O(N) if it is a skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Recursive: As it is similar to the preorder traversal, I'm just calculating sum for every node traversed and just sending sum below to the child nodes. Once reached to the leaf node(a node with no children) just adding the sum received from parent node to the totalSum which is a global variable.
*/

class Solution46Recursive {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    private Integer totalSum;
    public int sumNumbers(TreeNode root) {

        if(root==null){
            return 0;
        }

        totalSum =0;
        pathSum(root,0);
        
        return totalSum;
    }
    
    private void pathSum(TreeNode root, int sum){
        
        //base
        if(root==null){
            return;
        }
        
        sum = sum*10+root.val;
        
        if(root.left==null && root.right==null){
            totalSum += sum;
            return;
        }
        
        //logic
        pathSum(root.left,sum);
        pathSum(root.right,sum);
    }
}
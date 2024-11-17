# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

## Solution 1:
## Time Complexity:O(n)    Space Complexity:O(n)
## We use hashmap to store index of the inorder traversal, and while calling the helper function we pass the postorder array.
## We decrement the postorder value based on index, and find the inorder value and pass the left and right subarray.
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
class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Base Case: Empty Tree
        
        
        // Step 1: Root is the last element in postorder
        this.map=new HashMap<>();
        this.idx=postorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        return helper(postorder,0,inorder.length-1);
        
        
    }

    private TreeNode helper(int[] postorder,int start,int end)
    {
        if(start>end) return null;

        int rootVal= postorder[idx];
        idx--;

        int rootIdx=map.get(rootVal);

        TreeNode root=new TreeNode(rootVal);
        root.right=helper(postorder,rootIdx+1,end);
        root.left=helper(postorder,start,rootIdx-1);
       
        
        return root;
    }
}










## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
## Solution 2
## Time Complexity:O(n) Space Complexity:O(n)
## We use the current number and pass it as a local variable along with the root of a tree node and if its a leaf node we add it to the sum.
class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int currNum) {
        if (root == null) {
            return; // Base case: no node to process
        }

        // Update the current number with the node's value
        currNum = currNum * 10 + root.val;

        // If it's a leaf node, add the current number to the sum
        if (root.left == null && root.right == null) {
            sum += currNum;
            return;
        }

        // Recur for left and right subtrees
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}

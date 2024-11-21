//129. Sum Root to Leaf Numbers - https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
//Time Complexity: O(n)
//Space Complexity: O(h) : height of the tree

class Solution {
    //global scope to maintain end result
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum){
        //base case
        if(root == null){
            return;
        }
        //logic
        currNum = currNum * 10 + root.val;
        //leaf nodes
        if(root.left == null && root.right == null){
            result = result + currNum;
        }
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}
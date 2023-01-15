// Time Complexity: O(n)
// Space complexity: O(1)

// Approach: We have to traverse every branch until the leaf node and keep a global sum.
// We use recursive approach where we pass the root and the currNum of the element.
// In the recursive call we keep a local currNum to add all elements.
// Additionally, we check if we have reached the leaf node, we add this currNum to the global currSum.

class Solution {
    int currSum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return currSum;
    }
    private void helper(TreeNode root, int currNum){
    
        //base
        if(root==null) return;
        
        //logic
        
        currNum=currNum*10+root.val;

        helper(root.left,currNum);
        
        //inorder
        if(root.left==null && root.right==null){
            currSum+=currNum;
        }
        
        helper(root.right,currNum);
        
    }
}
// 129. Sum Root to Leaf Numbers
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
used a recursive helper function that traverses the tree nodes while keeping track of the current sum. At each node, 
updates the current sum by multiplying it by 10 and adding the node's value, and if the current node is a leaf, 
adds the computed sum to the total sum. Finally, recursively calls the helper function on the left and right 
subtrees, summing up the results.
*/

int sumNumbers(TreeNode* root) {
    return helper(root, 0, 0);
}
int helper(TreeNode* root, int sum, int currSum)
{
    if(root == NULL)
        return 0;
    
    currSum = currSum * 10 + root->val;
    if(root->left == NULL && root->right == NULL)
        return sum += currSum;

    return helper(root->left, sum, currSum) + helper(root->right, sum, currSum);
}
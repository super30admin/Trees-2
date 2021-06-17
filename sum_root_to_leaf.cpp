// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    // Global variable to keep track of total sum
    int total_sum = 0;
    
public:
    void sum_rec(TreeNode* root, int curr_sum)
    {
        if(!root)
            return;
        
        int new_sum;

        // Determine the value at the root    
        new_sum = root->val + (10*curr_sum);
        
        // Add to total sum if Leaf node
        if(!root->left && !root->right)
        {
            total_sum += new_sum;
            return;
        }
        
        // Keep traversing if Leaf Node not yet reached
        sum_rec(root->left, new_sum);
        
        sum_rec(root->right, new_sum);
        
        return;
    }
    
    int sumNumbers(TreeNode* root) {
        
        sum_rec(root, 0);
        
        return total_sum;
    }
};
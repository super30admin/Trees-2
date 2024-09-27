// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    void helper(TreeNode* root, int curSum, int &total_sum){
        if(root==NULL) return;
        
        curSum =curSum*10 + root->val;
        if(root->left==NULL && root->right==NULL){
            total_sum += curSum;
        }
        
       helper(root->left, curSum, total_sum);
        helper(root->right, curSum, total_sum);

    }
    
    int sumNumbers(TreeNode* root) {
        int total_sum=0;
        int curSum =0;
        helper(root, curSum, total_sum);
        return total_sum;
    }
};


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    void sumNumberRecur( TreeNode*root, string mystr, int &sum){
        if( root == nullptr ){
            return;
        }
        
        mystr += to_string( root->val );
        
        if( root->left == nullptr && root->right == nullptr ){
            sum += stoi( mystr );
        }

        sumNumberRecur( root->left, mystr, sum );
        sumNumberRecur( root->right, mystr, sum );
        
    }
    
    
    int sumNumbers(TreeNode* root) {
        int sum = 0;
        string mystr;
        sumNumberRecur( root, mystr, sum);
        return sum;
    }
};

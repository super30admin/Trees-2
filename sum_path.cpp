//TC: O(n) where n is number of tree elements
//SC: O(n) since the recursive stack grows till n elements



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
    int result=0;
    
    void preorder(TreeNode* root, int currval){
        
        if(root == NULL)
            return;
        
        currval = currval*10 + root->val;
        
        if(root->left == NULL && root->right == NULL)      
            result += currval;
        
        preorder(root->left, currval);
        preorder(root->right, currval);
        
        
    }
    
    
    int sumNumbers(TreeNode* root) {
        
        //can use a helper function to perform pre-order traversal using recursion
        int currval = 0;
        preorder(root, currval);
        return result;        
        
    }
    
    
};
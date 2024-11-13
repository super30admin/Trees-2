//we can traverse the tree using recursion eiter preorder, postorder or inorder
//here we need to to reach to the leaf node of the tree and see if the both left and right are null
// to get the the sum we need to keep track of two vairables one currSum and result
// we start with the root and at each stack call of recursion we add val*10 +currsum 
// once we reach the last node we can store that into result

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
    int result = 0;
private:
    void helper(TreeNode *root,int currSum)
    {
        if(root==NULL)
            return;
        currSum = currSum*10 + root->val;
        if(root->left == NULL && root->right == NULL)
            result +=currSum;
        helper(root->left,currSum);
        helper(root->right,currSum);

    }

public:
    int sumNumbers(TreeNode* root) {
        int currSum = 0;
        helper(root,currSum);
        return result;
    }
};
//Time complexity O(N)
//Space complexity O(log N)
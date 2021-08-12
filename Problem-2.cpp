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
/*
Time Complexity = O(N)
Space Complexity = O(h)
where N is the number of nodes in the tree and h is the height of the tree.
Solution with one local and one global variable.
*/
class Solution {
public:
    int sum=0;
    void helper(TreeNode* root, int currsum)
    {
        //base case
        if(root==NULL)
            return;
        
        //logic case
        currsum=currsum*10 + root->val;
        helper(root->left,currsum);
        if(root->left==NULL && root->right==NULL)
            sum+=currsum;
        helper(root->right,currsum);
    }
    int sumNumbers(TreeNode* root) {
        helper(root,0);
        return sum;
    }
};

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
/*
Time Complexity = O(N)
Space Complexity = O(h)
where N is the number of nodes in the tree and h is the height of the tree.
Solution with two local variable.
*/
class Solution {
public:
    int helper(TreeNode* root, int currsum, int sum)
    {
        //base case
        if(root==NULL)
            return 0;
        
        //logic case
        currsum=currsum*10 + root->val;
        if(root->left==NULL && root->right==NULL)
        {
            sum+=currsum;
            return sum;
        }
        return helper(root->left,currsum,sum)+helper(root->right,currsum,sum);
    }
    int sumNumbers(TreeNode* root) {
        return helper(root,0,0);
    }
};

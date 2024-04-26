 //Time O(n)
 //Space O(n)
 //Leetcode yes
 //Issue seen : none
class Solution {
public:
    int globalSum = 0;
    void dfs(TreeNode* root, int slate){
        if(!root) return ;

        slate = slate * 10 + root->val;
        if(!root->left && !root->right){
           globalSum = slate+globalSum;
        }
        dfs(root->left, slate);
        dfs(root->right, slate);
    }

    int sumNumbers(TreeNode* root) {
        if(!root) return 0;

        dfs(root, 0);
        return globalSum;
    }
};

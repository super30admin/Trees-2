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
    int ans;

    /*
    Time: O(N)
    Space: O(H) (Recursive Stack Space = Height of the Tree)
    */
    void call(TreeNode* root, int num){
      int curr = num*10 + root->val;

      /* Important */
      //Don't add for null node, as for leaf nodes there are 2 null children

      //only add when leaf node
      if(root->left == nullptr && root->right==nullptr){
        ans += curr;
        return;
      }
      
      if(root->left != nullptr){
        call(root->left,curr);
      }
      if(root->right != nullptr){
        call(root->right,curr);
      }
      
    }

    int sumNumbers(TreeNode* root) {
        ans = 0;
        
        call(root,0);

        return ans;

    }
};

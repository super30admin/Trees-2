// time: O(n)
// space: O(log n)

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
    void helper(string str, TreeNode* root) {
        str += to_string(root -> val);
        if(root -> left == NULL) {
            if(root -> right == NULL) {
                result += stoi(str);
                return;
            }
            else {
                helper(str, root -> right);
            }
            
            return;
        }
        helper(str, root -> left);
        if(root -> right != NULL) {
            helper(str, root -> right);
        }
        return;
        
    }
public:
    
    int sumNumbers(TreeNode* root) {
        helper("", root);
        return result;
    }

};
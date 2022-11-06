/*
Time Complexity: O(n)
Space Complexity: O(h)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/

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
    vector<int> inorder, postorder;
    int postorderIndex;
    unordered_map<int,int> postorderIndexMap;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        this->postorderIndex = postorder.size()-1;
        this->inorder = inorder;
        this->postorder = postorder;
        for(int i = 0; i <inorder.size(); i++){
            postorderIndexMap[inorder[i]]=i;
        }
        return buildTree(0,inorder.size()-1);
    }
    TreeNode* buildTree(int inStrt, int inEnd){
        if(inStrt>inEnd) return NULL;
        TreeNode* node = new TreeNode(postorder[postorderIndex]);
        postorderIndex--;
        int inorderIndex = getIndex(node->val);
        node->right = buildTree(inorderIndex+1,inEnd);
        node->left = buildTree(inStrt,inorderIndex-1);
        return node;
    }
    int getIndex(int ele){
         return postorderIndexMap[ele];
    }
};
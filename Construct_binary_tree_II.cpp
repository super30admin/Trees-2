// Time Complexity : O(n) ...... N is total number of elements in tree
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
 and postorder is the postorder traversal of the same tree, construct and return the binary tree.
*/

/*
Explaination :  watch for understanding - https://www.youtube.com/watch?v=AnzeyrnWCeY
*/


class Solution {
    int idx;
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size() == 0) return nullptr;
        unordered_map<int, int> hMap;

        for(int i=0; i<inorder.size(); i++){
            hMap[inorder[i]] = i;
        }
        idx = postorder.size()-1;
        return helper(hMap, 0, inorder.size()-1, postorder);
    }

    TreeNode* helper(unordered_map<int, int> &hMap, int start, int end,
    vector<int>& postorder){
        if(start > end) return nullptr;

        int rootVal = postorder[idx];
        idx--;

        int rootIdx = hMap[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        root->right = helper(hMap, rootIdx+1, end, postorder);
        root->left = helper(hMap, start, rootIdx-1, postorder);
        
        return root;
    } 
};
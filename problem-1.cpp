// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
first creates a hashmap to store the indices of elements in the inorder traversal for efficient lookup. 
Then, recursively builds the tree by dividing the postorder sequence into left and right subtrees based
on the root index obtained from the inorder sequence.This process continues until the entire tree is constructed, 
with each recursive call handling a subtree.
*/

class Solution {
public:
    int ind = 0;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        ind = postorder.size() - 1;
        unordered_map<int, int> inmap;
        for(int i = 0; i < inorder.size(); i++)
            inmap[inorder[i]] = i;
        return helper(postorder, 0, inorder.size()-1, inmap);
    }
    TreeNode* helper(vector<int>& postorder, int l, int r, unordered_map<int, int>& inmap)
    {
        if(l > r) return NULL;
    
        TreeNode* root = new TreeNode(postorder[ind]);
        int rootIdx = inmap[postorder[ind]];
        ind = ind - 1;

        root->right = helper(postorder, rootIdx + 1, r, inmap);
        root->left = helper(postorder, l, rootIdx - 1, inmap);

        return root;
    }
};
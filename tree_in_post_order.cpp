// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea here is to find the root, which is last element from postorder and find its index from 
// inorder. Then recursively find left and right nodes by splitting the postorder into left 
// side and right side.

#include <unordered_map>
#include<vector>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    std::unordered_map<int, int> map;
    int idx;
    TreeNode* buildTree(std::vector<int>& inorder, std::vector<int>& postorder) {
        if(inorder.size() == 0)
        {
            return nullptr;
        }

        for(int i = 0; i < inorder.size(); i++)
        {
            map[inorder[i]] = i;
        }
        idx = inorder.size()-1;
        return helper(postorder, 0, inorder.size()-1);
    }

    TreeNode* helper(std::vector<int>& postorder, int s, int e)
    {
        if(s > e)
        {
            return nullptr;
        }

        int rootVal = postorder[idx];
        int rootIdx = map[rootVal];

        TreeNode* root = new TreeNode(rootVal);

        idx--;

        root->right = helper(postorder, rootIdx+1, e);
        root->left = helper(postorder, s, rootIdx-1);
        return root;
    }

};
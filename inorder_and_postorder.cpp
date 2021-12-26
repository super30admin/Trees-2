//Time complexity : O(n)
//Space complexity : O(n)

//Approach :
            // Last element of post order traversal should give us root element
            // Take the root and search for it in the inorder array
            // All the elements to the left of root will be in left subtree
            // All the elements to the right of root will be in right subtree
            // Build the tree accordingly
            // As we are making use of postorder traversal, we should be building the right subtree first then the left subtree

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
    map<int,int> inorder_map;
    int idx;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size() == 0)
            return nullptr;
        
        idx = postorder.size() - 1;
        
        for(int i = 0 ; i < inorder.size(); i++)
        {
            inorder_map[inorder[i]] = i; 
        }
        
        return builder(postorder, 0, postorder.size() -1);
    }
    
    TreeNode* builder(vector<int> postorder,int start,int end)
    {
        if(start > end)
            return nullptr;
        
        int rootVal = postorder[idx];
        idx--;
        int index = inorder_map[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        
        root->right = builder(postorder, index + 1, end);
        root->left = builder(postorder, start, index - 1);
       
        return root;
    }
};
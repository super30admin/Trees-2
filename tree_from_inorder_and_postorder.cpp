// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. We know that the last element in postorder traversal is the root of the tree.
// 2. We find the root in inorder traversal and divide the inorder traversal into left and right subtree.
// 3. We recursively build the right subtree first and then the left subtree.

class Solution {
    private: 
        int postorderIndex;
        unordered_map<int, int> map;
        TreeNode* helper(vector<int>& inorder, vector<int>& postorder, int inorderStart, int inorderEnd){
            //base case
            if(inorderStart > inorderEnd){
                return nullptr;
            }
            int rootVal = postorder[postorderIndex];
            TreeNode* root = new TreeNode(rootVal);
            postorderIndex--;
            int rootIndexinInorder = map[rootVal];
            //left and right subtree
            root -> right = helper(inorder, postorder, rootIndexinInorder + 1, inorderEnd);
            root -> left = helper(inorder, postorder, inorderStart, rootIndexinInorder - 1);
            
    
            return root;
        }
    public:
        TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
            postorderIndex = postorder.size() - 1;
            for(int i = 0; i < inorder.size(); i++){
                map[inorder[i]] = i;
            }
            return helper(inorder, postorder, 0, inorder.size() - 1);
        }
    };
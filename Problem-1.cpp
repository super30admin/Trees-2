// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The last element of postorder vector is the root. Find it's index in the inorder vector using map.
// calculate the index of the end of left subtree and it's length.
// Use the indices to recursively traverse the vectors and return the tree.

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
        TreeNode * constructBTree(vector<int>& inorder, int inStart, int inEnd, vector<int>& postorder, int postStart, int postEnd, unordered_map<int,int> & mp){
            if(inStart > inEnd || postStart > postEnd) return NULL;
            TreeNode* root = new TreeNode(postorder[postEnd]);
            int rootidx = mp[root->val];
            int leftidx = rootidx - inStart;
    
            root->left = constructBTree(inorder, inStart, rootidx-1, postorder, postStart, postStart+leftidx-1,mp);
            root->right = constructBTree(inorder, rootidx+1, inEnd, postorder, postStart+leftidx, postEnd-1, mp);
            return root;
        }
        TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
            int inStart = 0; int inEnd = inorder.size()-1;
            int postStart = 0; int postEnd = postorder.size()-1;
            unordered_map<int,int>mp;
            for(int i=inStart; i<=inEnd; i++){
                mp[inorder[i]] = i;
            }
            return constructBTree(inorder, inStart, inEnd, postorder, postStart, postEnd, mp);
            
        }
    };
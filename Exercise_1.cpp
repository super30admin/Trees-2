// Time Complexity                              :  O(N) where N is the length of the inorder and postorder arrays
// Space Complexity                             :  O(N) due to values stored in the function stack. 
//                                                 O(N) in case of a skewed tree otherwise O(H) where H is 
//                                                  the height of the tree.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  


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
private: 
    int pi;
    
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n = inorder.size();
        if(n == 1) return new TreeNode(inorder[0]);
        pi = n - 1;
        return bTree(inorder, postorder,0,n-1);
    }
    
    TreeNode* bTree(vector<int>& inorder, vector<int>& postorder, int start, int end) {
        if(start > end) return NULL;
        
        TreeNode *nn = new TreeNode(postorder[pi--]);
        int pos;
        for(int i=start;i<=end;i++) {
            if(inorder[i] == nn->val) {
                pos = i; 
                break;
            }
        }
        
        nn->right = bTree(inorder,postorder,pos+1,end);
        nn->left = bTree(inorder,postorder,start,pos-1);
        return nn;
    }
};
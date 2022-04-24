// Time Complexity                              :  O(N), where N is the number of nodes in the tree.
// Space Complexity                             :  O(1) for iterative approach and O(N) for the recursive
//                                                 approach. O(N) in case of a skewed tree.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/

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
    int s;
    
public:
    int sumNumbers(TreeNode* root) {
        s = 0;
        // sn(root,0);
        sn1(root);
        return s;
    }
    
    // using recursive approach
    void sn(TreeNode* root, int val) {
        if(!root) return;
        
        val = val*10 + root->val;
        
        if(!root->left and !root->right) {
            s += val;
        }
        
        sn(root->left,val);
        sn(root->right,val);
    }
    
    // using iterative approach
    void sn1(TreeNode *root) {
        if(!root) return;
        stack<pair<TreeNode*,int>> st;
        int v = 0;
        
        while(root != NULL or !st.empty()) {
            
            while(root != NULL) {
                v = v*10 + root->val;
                st.push({root, v});
                root = root->left;
            }
            
            root = st.top().first;
            v = st.top().second;
            
            if(root != NULL and root->left == NULL and root->right == NULL) {
                s += v;   
            }
            
            root = root->right;
            st.pop();
        }
    }
};
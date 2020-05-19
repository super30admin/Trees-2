// Time Complexity : O(n)
// Space Complexity : O(h); h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Iterative solution: Maintain a stack and keep adding a pair of root and its corresponding sum and its left children 
// 2. Once there are no left children, check if last node popped was a leaf node. If yes, add to final result
// 3. Move to the right of currently popped element and continue until root is null and the stack is empty

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
    int sumNumbers(TreeNode* root) {
        int result = 0, sum = 0;
        stack<pair<TreeNode*,int>> st;
        while(root!=nullptr || !st.empty()){
            while(root!=nullptr){
                sum = sum*10 + root->val;
                st.push({root,sum});
                root=root->left;
            }
            auto pair1 = st.top();
            st.pop();
            root=pair1.first;
            sum=pair1.second;
            cout<<"sum: "<<sum<<endl;
            if(root->left==nullptr && root->right==nullptr)
                result+=sum;
            root=root->right;
        }
        return result;
    }
};
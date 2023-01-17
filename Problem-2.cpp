i


129. Sum Root to Leaf Numbers

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.











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

/*

TC = O(n)
SC = O(1)


recursive solution
---------------------

class Solution {
public:
    int totalsum;

    int sumNumbers(TreeNode* root) {
        
        helper(root, 0);
        return totalsum;
    }

    void helper(TreeNode* root, int cursum) {
            if(root == NULL) {
                return;
            }
            ;
            if ((root-> left == NULL) && (root->right == NULL)) {
                totalsum += cursum *10 + root->val;
            }
            cursum = cursum *10 + root->val;
            helper (root-> left, cursum);
            helper (root-> right, cursum);
            return;
    }
};


*/


TC = O(n)
SC = O(n)


/*
iterative solution
---------------------
*/

class Solution {
public:
    

    int sumNumbers(TreeNode* root) {
        stack<TreeNode*> st;
        stack<int> num;
        int cursum = 0;
        int totalsum = 0;

        while ((root != NULL) || (!st.empty())) {
            while (root != NULL) {
                cursum = cursum*10 + root->val;
                st.push(root);
                num.push(cursum);
                root = root->left;
            }
            root = st.top();
            st.pop();
            cursum = num.top();
            num.pop();
            if ((root->left == NULL) && (root->right == NULL)) {
                totalsum += cursum; 
            }
            root = root->right;
        }
        return totalsum;
    }
};




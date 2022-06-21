// Recursive Version
// Time Complexity - O(n) - Since we are iterating over 'n' nodes in the tree.
// Space Complexity - O(h) - 'h' is the height of the tree.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    int answer;
    private:
    int helper(TreeNode* root, int curr){
        // base
        if(!root) return 0;
        // logic
        helper(root->left, curr*10 + root->val);
        if(!root->left && !root->right)
            answer += curr*10 + root->val;
        helper(root->right, curr*10 + root->val);
        return answer;
    }
public:
    int sumNumbers(TreeNode* root) {
        return helper(root,0);
    }
};


// Iterative version
// Time Complexity - O(n) - Since we are iterating over 'n' nodes in the tree.
// Space Complexity - O(h) - 'h' is the height of the tree.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        stack<TreeNode*> st;
        stack<int> st2;
        int answer = 0;
        int curr = 0;
        while(root || !st.empty()){
            while(root){
                curr = curr*10 + root->val;
                st.push(root);
                st2.push(curr);
                root = root->left;
            }
            root = st.top();
            st.pop();
            curr = st2.top();
            st2.pop();
            if(!root->left && !root->right)
                answer += curr;
            root = root->right;
        }
        return answer;
    }
};
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Build a hashmap of the inorder array for fast lookups and pass it by reference to the recursion, use the postorder array to find the next root
// Build the right subtree first (since we have postorder array), the start index becomes rootIdx + 1 and the end index is the same as the end index of the parent
// When we build the left subtree, the start index remains the same as the parent start index, the end becomes rootIdx - 1


class Solution {
private:
    TreeNode* helper(vector<int>& postorder, unordered_map<int, int>& inMap, int& idx, int start, int end) {
        // base case:
        if(start > end) {
            return nullptr;
        }

        // logic: 
        int rootVal = postorder[idx];
        int rootIdx = inMap[rootVal];
        idx--;

        TreeNode* root = new TreeNode(rootVal);

        root->right = helper(postorder, inMap, idx, rootIdx+1, end);
        root->left = helper(postorder, inMap, idx, start, rootIdx-1);

        return root;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int, int> inMap;
        int n = inorder.size();
        for(int i=0; i<n; i++) {
            inMap[inorder[i]] = i;
        }
        int idx = n-1;
        return helper(postorder, inMap, idx, 0, n-1);
    }
};
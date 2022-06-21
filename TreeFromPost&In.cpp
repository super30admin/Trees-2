// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode.

class Solution {
    unordered_map<int, int> map;
    int idx;
    private:
    TreeNode* helper(vector<int>& arr, int start, int end){
        if(start > end)
            return NULL;
        
        int currRoot = arr[idx];
        idx--;
        int currRootIdx = map[currRoot];
        
        TreeNode* root = new TreeNode(currRoot);
        root->right = helper(arr, currRootIdx + 1, end);
        root->left = helper(arr, start, currRootIdx - 1);
        
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        idx = postorder.size()-1;
        for(int i = 0; i < inorder.size(); i++)
            map[inorder[i]] = i;
        
        return helper(postorder, 0, postorder.size()-1);
    }
};
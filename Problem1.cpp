// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    TreeNode* helper(vector<int>& inorder, vector<int>& postorder, int st, int end,int &idx, map<int, int> &m ){
        if(st>end || idx<0) return NULL;
        
        TreeNode* root = new TreeNode(postorder[idx]);
        int root_idx = m[root->val];
        idx--;
        
        root->right = helper(inorder, postorder, root_idx+1, end, idx,m);
        root->left = helper(inorder, postorder, st, root_idx-1, idx, m);
        
        return root;
        
    }
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        map<int, int> m;
        for(int i=0; i<inorder.size(); i++){
            if(m.find(inorder[i])==m.end())
                m[inorder[i]]=i;
        }
        int idx = postorder.size()-1;
        return helper(inorder, postorder, 0, inorder.size()-1, idx, m);
    }
};

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes


class Solution {
public:
    unordered_map<int,int>map;
    int idx;
    TreeNode* helper(vector<int> inorder, vector<int> postorder,int start,int end)
    {
        if(start>end)
        {
            return nullptr;
        }
        int rootval=postorder[idx];
        TreeNode *root=new TreeNode(rootval);
        idx--;
        int inidx=map[rootval];
        root->right=helper(inorder,postorder,inidx+1,end);
        root->left=helper(inorder,postorder,start,inidx-1);
        
        return root;
        
    }
    
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        idx=postorder.size()-1;
        for(int i=0;i<inorder.size();i++)
        {
            map[inorder[i]]=i;
        }
        return helper(inorder,postorder,0,inorder.size()-1);
        
    }
};

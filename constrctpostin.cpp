/*
TC : O(n)
Sc: O(n)
 */
class Solution {
public:
unordered_map<int, int> map;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for(int i=0;i<inorder.size();i++)
        {
            map[inorder[i]]=i;
        }
        return dfs(postorder, 0 ,postorder.size()-1, inorder, 0, inorder.size()-1);
    }
    TreeNode* dfs(vector<int>& postorder,int startP, int endP, vector<int>& inorder, int startI, int endI) 
    {
        if(startP>endP)
            return nullptr;
        if(startP==endP)
            return new TreeNode(postorder[endP]);

        TreeNode* root=new TreeNode(postorder[endP]);
        int index= map[postorder[endP]];
        int numL= index-startI;
        int numR= endI-index;

        root->left=dfs(postorder, startP, startP+numL-1, inorder, startI, index-1);
        root->right=dfs(postorder, endP-numR, endP-1, inorder, index+1, endI);

        return root;
    }
};
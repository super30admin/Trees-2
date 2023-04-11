class Solution {
    // TC - O(n)
    // SC - O(n) for inorder map + recusrion stack
public:
    int postOrderIndex;
    unordered_map<int,int> umap;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        postOrderIndex = postorder.size()-1;
        for(int i =0; i<inorder.size();i++){
            umap[inorder[i]] = i;
        }

        return buildTreeRecur(postorder, 0, inorder.size()-1);
        
    }
     TreeNode* buildTreeRecur(vector<int>& postorder, int inStIndex, int inEndIndex){
         if(inStIndex>inEndIndex) return nullptr;

         TreeNode* root = new TreeNode(postorder[postOrderIndex]);
         int rootIndex = umap[postorder[postOrderIndex--]];
         
         root->right = buildTreeRecur(postorder,rootIndex+1, inEndIndex);
         root->left = buildTreeRecur(postorder,inStIndex, rootIndex-1);
         return root;
     }
};
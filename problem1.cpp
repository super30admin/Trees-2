//Time Complexity - O(n)
//Space Complexity - O(n)
class Solution {
public:
    unordered_map<int,int>m;
    int idx;
    TreeNode* helper(vector<int>postorder,int start, int end){
        if(start>end){
            return NULL;
        }
        int rootval=postorder[idx];
        idx--;
        TreeNode* root=new TreeNode(rootval);
        int rootidx=m[rootval];
        root->right=helper(postorder,rootidx+1,end);
        root->left=helper(postorder,start,rootidx-1);
        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size()==0)
            return NULL;
        idx=postorder.size()-1;
        for(int i=0;i<inorder.size();i++){
            m[inorder[i]]=i;
        }
        return helper(postorder,0,idx);
    }
};
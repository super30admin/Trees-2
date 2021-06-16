class Solution {
public:
    int index;
    int find_index(vector<int> &inorder,int l,int r,int data)
    {
        for(int i=l;i<=r;i++)
        {
            if(inorder[i]==data)
                return i;
        }
        return -1;
    }
    TreeNode* buildpre(vector<int> &inorder,vector<int> &postorder,int l,int r)
    {
        if(r<l)return nullptr;
        TreeNode* root=new TreeNode(postorder[index]);
        int pos=find_index(inorder,l,r,postorder[index]);
        index--;
         root->right=buildpre(inorder,postorder,pos+1,r);
        root->left=buildpre(inorder,postorder,l,pos-1);
       
        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        index=postorder.size()-1;
       return(buildpre(inorder,postorder,0,postorder.size()-1));
    }
};

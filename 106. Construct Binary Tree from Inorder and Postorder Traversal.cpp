class Solution {
public:
    //TC-O(N)
    //SC-O(N)
    unordered_map<int,int> h;

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for(int i=0;i<inorder.size();i++){
            h[inorder[i]]=i;
        }
            int idx=inorder.size()-1;
        return buildtree(inorder,postorder,0,inorder.size()-1,idx);
    }
    
    TreeNode* buildtree(vector<int>& inorder, vector<int>& postorder,int start,int end,int &idx){
        if(start>end)return NULL;
    int curr=postorder[idx];
        idx--;
        TreeNode *root=new TreeNode(curr);
        int pivot=h[curr];
        root->right=buildtree(inorder,postorder,pivot+1,end,idx);
        root->left=buildtree(inorder,postorder,start,pivot-1,idx);
       
        return root;
        
    }
};
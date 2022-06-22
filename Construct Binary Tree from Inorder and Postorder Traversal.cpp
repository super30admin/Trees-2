//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    int index;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        
        index=postorder.size()-1;
        unordered_map<int,int> mp;
        
        for(int i=0;i<inorder.size();i++){
            mp[inorder[i]]=i;
        }
        
        return buildTree(postorder,mp,0,inorder.size()-1);
    }
    
    TreeNode* buildTree(vector<int> &postorder,unordered_map<int,int> &mp,int start,int end){
        
        if(start>end || index<0){
            return NULL;
        }
        
        TreeNode* root=new TreeNode(postorder[index--]);
        if(start==end){
            return root;
        }
        
        int search=mp[root->val];
        root->right=buildTree(postorder,mp,search+1,end);
        root->left=buildTree(postorder,mp,start,search-1);
        return root;
    }
};
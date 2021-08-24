// Time complexity-O(n);
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// we use the  preorder to keep track of the root of each subtree
// iterate over the preorder array
// find the position of that element in the inorder array
// all the elements to the left of that position will be used to build the left subtre while those on the right will be used to build the right sub tree


  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    unordered_map<int,int>hash_map;
    int idx =0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size()==0){
            return nullptr;
        }
        for(int i=0;i<inorder.size();i++){
            hash_map[inorder[i]] =i;
        }
        idx =0;
        
        int start = 0;
        int end= inorder.size()-1;
        return helper(preorder,inorder,start,end);
        
    }
    
    TreeNode*  helper(vector<int>& preorder, vector<int>& inorder,int start,int end){
        // base 
            if(start> end){
                return nullptr;
            }
        int rootIdx;//inorder root
        rootIdx = hash_map[preorder[idx]];
        
        // logic
       
        TreeNode * root = new TreeNode(preorder[idx]);
        
        idx++; 
        // recurse 
        root->left=helper(preorder,inorder,start,rootIdx-1);
        root->right=helper(preorder,inorder,rootIdx+1,end);
        return root;
    }
};
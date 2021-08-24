// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// build a hash map to represent the inorder nodes and its index for constant time check up
// go to end of the post order array to get the root
// recursively build the right subtree then build the left subtree
// right subtree must be built first because in post order when iteratinng from the right the right subtree is encountered first

class Solution {
public:
    int idx=0;
    unordered_map<int,int>hash_map;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.size()==0 || inorder.size()==0){
            return nullptr;
        }
        for(int i=0;i<inorder.size();i++){
            hash_map[inorder[i]] =i;
        }
        idx =postorder.size()-1;
        
        int start = 0;
        int end= inorder.size()-1;
        return helper(postorder,inorder,0,end);
    }
    TreeNode*  helper(vector<int>& postorder, vector<int>& inorder,int start,int end){
        // base 
            if(idx<0 || start> end){
                return nullptr;
            }
        //int rootIdx;//inorder root
        int rootIdx = hash_map[postorder[idx]];
        
        // logic
        TreeNode* root = new TreeNode(inorder[rootIdx]);
        idx--; 
        
        // recurse
        root->right=helper(postorder,inorder,rootIdx+1,end);
        root->left=helper(postorder,inorder,start,rootIdx-1);
        
        return root;
    }
};
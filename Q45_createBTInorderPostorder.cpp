
// ## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/



//Did this code run on leetcode :Yes
//idea- optimization using hash map
//TC - O(n) as hash map search is O(1), SC - O(n) for nodes in hash map

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    unordered_map <int, int> m1; //global
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
      
        for(int i=0; i< inorder.size(); i++){
            
            m1[inorder[i]] = i;
        }
        
        int inindex_s=  0;
        int inindex_e= inorder.size()-1;
        int idx = postorder.size()-1;
        return helper( postorder,inindex_s, inindex_e, idx);
    }
    
    
    TreeNode* helper(vector<int>& postorder, int inindex_s, int inindex_e, int &idx){
   
        
        if ( inindex_s > inindex_e)
        {
            return NULL;
        } 
  
        int rootVal = postorder[idx];
        TreeNode* root= new TreeNode( rootVal);
        idx--;
        int rootIndx = m1[rootVal];
        
        
        root->right = helper( postorder, rootIndx+1 , inindex_e, idx);
       root->left = helper( postorder,  inindex_s, rootIndx-1 ,idx );
        return root;
    
    }
};



//soln not working/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        
        int inindex_s=0;
        int inindex_e = inorder.size()-1;
        
        int postindex_s =0;
        int postindex_e = postorder.size()-1;
        
        return helper( inorder, postorder, inindex_s , inindex_e , postindex_s, postindex_e);
    }
    
    TreeNode* helper( vector<int>& inorder, vector<int>& postorder, int inindex_s, int inindex_e, int
                    postindex_s , int postindex_e){
        
        
         
        
        if( postindex_s > postorder.size()-1 || postindex_e > postorder.size()-1  || inindex_s >inorder.size()-1 || inindex_e > inorder.size()-1){
            return NULL;
        }
        if ( postindex_s > postindex_e || inindex_s > inindex_e)
        {
            return NULL;
        } 
        
          cout<< postindex_s<< postindex_e <<" postorder" <<endl;
        cout<< inindex_s << inindex_e << "inorder" <<endl;
        
  
        int rootVal = postorder[postindex_e];
        TreeNode* root= new TreeNode( rootVal);
        int idx= -1;
        
        for(int i=inindex_s; i<= inindex_e; i++){
            if(inorder[i]== rootVal){
                idx= i-inindex_s ;
                break;
            }
        }
        cout<< idx <<endl;
        
        
        root->right = helper( inorder, postorder, inindex_s + idx +1 , inindex_e, postindex_e-idx-1 , postindex_e -1);
       root->left = helper( inorder, postorder, inindex_s, inindex_s + idx-1,postindex_s, postindex_e-1-idx);
        return root;
    }
};
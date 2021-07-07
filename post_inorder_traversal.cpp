

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

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Hashmapsolution
// Time Complexity : O(n)
// Space Complexity : O(n).
//1. Find build hashmap for the inorder traversal array
//2. Find root using hashmap and divide into left and right array
//2. repeat step 1 for left part
//3. repeat step 1 for right part


class Solution {
public:
    unordered_map <int, int> tree_map;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        //base case
        if(inorder.size()==0 || postorder.size()==0) return NULL;
        for(int i =0; i< inorder.size(); i++){
            tree_map[inorder[i]] = i;
        }
        return helper(inorder, postorder, 0, inorder.size()-1, postorder.size()-1);
    }
    
    TreeNode* helper(vector<int>&  inorder,vector<int>&  postorder, int in_start,int in_end,int post_index){
        //returning condition
        if(in_start > in_end) return NULL;
        TreeNode* root = new TreeNode(postorder[post_index]);
        
        int index = tree_map[root->val];
        
        root->right = helper(inorder, postorder, index+1, in_end, post_index-1);
        root->left  = helper(inorder, postorder, in_start, index-1, post_index-in_end+index-1);
        return root;
    }
    
};

class Solution {
public:
    unordered_map<int,int> my_map;
    int post_index;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        //edge
        if(inorder.size()==0 && postorder.size()==0){
            return NULL;
        }
        for(int i=0; i<inorder.size();i++){
            my_map[inorder[i]] =i;
        }
        TreeNode* root;
        //recurse
        post_index= postorder.size()-1;
        root = dfs(postorder, 0, postorder.size()-1);
        return root;
    }
    
    TreeNode* dfs(vector<int>& postorder, int in_start, int in_end){
        //return
        if(in_start > in_end){
            return NULL;
        }
            
        //logic
        if(post_index<0){
            return NULL;
        }
        
        int val = postorder[post_index];
        TreeNode* temp = new TreeNode(val);
        int index = my_map[val];
        post_index--;
        
        temp->right  = dfs(postorder, index+1, in_end);
        temp->left  = dfs(postorder, in_start, index-1);
        return temp;
    }
};
//Recursive solution
// Time Complexity : O(n^2)
// Space Complexity : O(n).
//1. Find root and divide into left and right array
//2. repeat step 1 for left part
//3. repeat step 1 for right part
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        //base case
        if(inorder.size()==0 || postorder.size()==0) return NULL;
        
        return helper(inorder, postorder, 0, inorder.size()-1, postorder.size()-1);
    }
    
    TreeNode* helper(vector<int>&  inorder,vector<int>&  postorder, int in_start,int in_end,int post_index){
        //returning condition
        if(in_start > in_end) return NULL;
        TreeNode* root = new TreeNode(postorder[post_index]);
        int index;
        for( index =0; index< inorder.size(); index++){
            if(inorder[index] == root->val) break;
        }
        root->right = helper(inorder, postorder, index+1, in_end, post_index-1);
        root->left  = helper(inorder, postorder, in_start, index-1, post_index-in_end+index-1);
        return root;
    }
    
};

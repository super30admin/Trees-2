/*
  Construct_Tree_From_Preorder_and_Inorder.cpp
 
  Approach: Postorder gives us the root of subtree at each level in reverse order.
  Inorder gives us the left and right subtree of given root. Use hashmap to store the each node and corresponding index value from inorder array.
   
  TC: O(N), N = Number of nodes in tree
  SC: O(h + N), height of tree (maximum stack space), N = Number of nodes in tree;
*/
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

//Definition for a binary tree node.
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
    unordered_map<int,int> tracker;
    int id;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size()==0)
            return NULL;
        for(int i=0;i<inorder.size();i++) tracker[inorder[i]] = i;
        id = postorder.size()-1;
        return constructTree(postorder, 0, postorder.size());
    }
   
    TreeNode* constructTree(vector<int> postorder, int start, int end){
        if(start >= end)
            return NULL;
        TreeNode* node = new TreeNode(postorder[id--]);
        int index = tracker[node->val];
        node->right = constructTree(postorder, index+1, end);
        node->left = constructTree(postorder, start, index);
        return node;
    }
     
    void inorderTraversal(TreeNode* node){
            if(node!=NULL){
                inorderTraversal(node->left);
                cout<<node->val<<"\t";
                inorderTraversal(node->right);
            }
    }
         
};

int main(int argc, const char * argv[]) {
    vector<int> postorder = {9,15,7,20,1};
    vector<int> inorder = {9,1,15,20,7};
    Solution s;
    TreeNode* root= s.buildTree(inorder, postorder);
    s.inorderTraversal(root);
    return 0;
}

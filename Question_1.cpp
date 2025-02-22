#include<bits/stdc++.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
#include<unordered_map>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}    
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

TreeNode* dnc(vector<int>&inorder,vector<int>&postorder,unordered_map<int,int>&table,int p1,int p2,int i1,int i2){
    if(p1>p2) return NULL;
    if(p1==p2) return new TreeNode(postorder[p2]);
    int inorder_root_index = table[postorder[p2]];
    int left_subtree_size = inorder_root_index-i1;
    TreeNode* leftChildNode = dnc(inorder,postorder,table,p1,p1+left_subtree_size-1,i1,inorder_root_index-1);
    TreeNode* rightChildNode = dnc(inorder,postorder,table,p1+left_subtree_size,p2-1,inorder_root_index+1,i2);
    return new TreeNode(postorder[p2],leftChildNode,rightChildNode);
}
TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
    int n = postorder.size();
    unordered_map<int,int>table;
    for(int i=0;i<=n-1;i++) table[inorder[i]]=i;
    return dnc(inorder,postorder,table,0,n-1,0,n-1);
}

int main(){
    vector<int> inorder = {9,3,15,20,7};
    vector<int> postorder = {9,15,7,20,3};
    TreeNode* root = buildTree(inorder,postorder);
    return 0;
}
// Time Complexity: O(n)
// Space Complexity: O(n)   
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Explanation: The tree is constructed from the inorder and postorder traversal.
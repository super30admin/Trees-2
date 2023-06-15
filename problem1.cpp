/*

// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

Taking care that first right and then left are mentioned in the post order of the array


// Your code here along with comments explaining your approach
Take the root from the post order in dereasing order of the array
For each root first traverse the right root due to postorder Left-right-root in the inorder array
then traverse the left root in the inorder array
Continue this process for every subtree untill start > end , the two pointers to the inorder array.


*/


#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x,TreeNode* left,TreeNode* right):val(x),left(left),right(right){};
    TreeNode():val(0),left(nullptr),right(nullptr){};
    TreeNode(int x):val(x),left(nullptr),right(nullptr){};

};

class Solution {
    int idx{};
public:

    TreeNode* helper(unordered_map<int,int>& hash_set,vector<int>& postorder,int start, int end){
        if(start>end) return nullptr;
        int val = postorder.at(idx);
        cout<<val;
        int gg = hash_set[val];
        idx--;
        TreeNode* root = new TreeNode(val);
        root->right = helper(hash_set,postorder,gg+1,end);
        root->left = helper(hash_set,postorder,start,gg-1);
        return root;
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map <int,int> hash_set{};
        int n = inorder.size();
        for(int i{};i<n;++i){
            hash_set[inorder.at(i)] = i;
        }
        idx = n-1;
        int val = postorder.at(idx);
        int gg = hash_set[val];
        idx--;
        TreeNode* root = new TreeNode(val);
        root->right = helper(hash_set,postorder,gg+1,n-1);
        root->left = helper(hash_set,postorder,0,gg-1);
        return root;
    }
};
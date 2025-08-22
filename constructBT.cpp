#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
/*
Here I have used a recursive function to form a binary tree using a
map to initially store the index of the inorder array as value and elements as value
Then the recursive fucntion is called and the root is returned
*/
class Solution{
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int idx = postorder.size()-1;
        unordered_map<int, int> map;
        for (int i = 0; i < inorder.size(); i++) {
            map[inorder[i]] = i;
        }
        return helper(postorder, 0, postorder.size() - 1, map,idx);
    }
private:
    TreeNode* helper(vector<int>& postorder, int start, int end, unordered_map<int, int>& map, int& idx) {
        
        if (start > end) return nullptr;

        int rootVal = postorder[idx--];
        TreeNode* root = new TreeNode(rootVal);
        int rootIdx = map[rootVal];
        

        root->right = helper(postorder, rootIdx + 1, end, map,idx);
        root->left = helper(postorder, start, rootIdx - 1, map,idx);
        return root;
    }
};

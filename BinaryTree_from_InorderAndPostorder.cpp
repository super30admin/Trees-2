//Time Complexity and Space Complexity : O(n^2)
#include<iostream>
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
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.empty()) return nullptr;

        int val = postorder.back();

        int x = -1;
        for(int i = 0; i < inorder.size(); i++) {
            if(inorder[i] == val) {
                x = i;
                break;
            }
        }

        vector<int> il(inorder.begin(), inorder.begin() + x);
        vector<int> ir(inorder.begin() + x + 1, inorder.end());
        vector<int> pl(postorder.begin(), postorder.begin() + il.size());
        vector<int> pr(postorder.begin() + il.size(), postorder.end() - 1);

        TreeNode* root = new TreeNode(val);
        root->left = buildTree(il, pl);
        root->right = buildTree(ir, pr);

        return root;
    }
};
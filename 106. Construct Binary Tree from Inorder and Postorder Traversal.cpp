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
    int pos;
    unordered_map<int,int> idx;

    /*
    Time Complexity: O(N)
    Space Complexity: O(N)

    For a value v in post-order, let idx be its index in inorder
    Then all values from 0 to idx - 1 will be in its left subtree, 
    and values from idx + 1 to n-1 will be in its right subtree

    This procedure follows recursively.

    Now, since post order is left-right-root, so root values will always appear after its left and right subtree nodes
    and right subtree nodes will appear after left subtree nodes

    So, the root of the whole tree will appear at the last position in post-order

    Bearing this in mind, we can start picking elements from the last position and try to go right first

    At every call, we decrement the global vairable p and pick root-value from post-order one by one sequentially
    */
    TreeNode* call(int l, int r, vector<int>& post){
      if(l>r)  return nullptr;

      int value = post[pos];
      auto node = new TreeNode(value);
      pos--;

      int index = idx[value];
      node->right = call(index+1, r, post);
      node->left = call(l, index-1, post);

      return node;
    }

    TreeNode* buildTree(vector<int>& in, vector<int>& post) {
      int n = in.size();
      for(int i=0;i<n;i++){
        idx[in[i]] = i;
      }

      pos = n-1;
      return call(0,n-1,post);
    }
};

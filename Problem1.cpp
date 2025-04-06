// Time Complexity : O(n) n is array size(# of nodes).
// Space Complexity : O(n) size of stack in recursion.
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Perform similar steps as used to build preorder and inorder.
// 2. Here root will start from last element of postorder array but we will travel right first.
// 3. Build right subtree first than left (here right root=previous element in postorder and left root=prev - #of elements towards right in inorder traversal )

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
    TreeNode* nhead=nullptr;
    TreeNode* bt(vector<int>& inorder, vector<int>& postorder,int rt,int f,int l,TreeNode* t){
        if(f>l){
            return nullptr;
        }
        int io;
        for (int i=f;i<=l;i++){
            if(inorder[i]==postorder[rt]){
                io=i;
            }
        }

        t= new TreeNode(postorder[rt]);
        (t->right) = bt(inorder,postorder,rt-1,io+1,l,t->right);
        (t->left) = bt(inorder,postorder,rt-(l-io+1),f,io-1,t->left);
        return t;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n=postorder.size();
        nhead=bt(inorder,postorder,n-1,0,inorder.size()-1,nhead);
        return nhead;
    }
};
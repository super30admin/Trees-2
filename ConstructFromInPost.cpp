// Time Complexity : o(n)
// Space Complexity : o(n)
// Where n = number of elements in the list given
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    TreeNode *helper(vector<int>& postorder, vector<int>& inorder, int ps, int pe, int is, int ie) {
        //base case
        if(ps > pe) {
            return NULL;
        }
        
        //1.create root node which is first node of postorder
        TreeNode *root = new TreeNode(postorder[pe]);
        //2.find root node in inorder
        int k = -1;
        for(int i=is;i<=ie;i++) {
            if(root->val == inorder[i]) {
                k = i;
                break;
            }
        }
        //3.count of elements in left subtree according to inorder
        int leftCount = k - is;
        //4.left and right calls and attach it to root node and return it
        root->left = helper(postorder,inorder,ps,leftCount+ps-1,is,k-1);
        root->right = helper(postorder,inorder,ps+leftCount,pe-1,k+1,ie);
        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n = inorder.size();
        return helper(postorder,inorder,0,n-1,0,n-1);
    }
};
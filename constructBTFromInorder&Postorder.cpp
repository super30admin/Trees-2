//time complexity: O(n)
//space complexity:O(n)
//approach: using hashmap and traversing in inorder & postorder.
//solved on leetcode? yes
//problem faced? no

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
    int postidx;
    vector<int>postorder;
    vector<int>inorder;
    map<int,int>map;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size()==0 || postorder.size()==0)
            return NULL;
        this->postorder=postorder;
        this->inorder=inorder;
        postidx=postorder.size()-1;
        int idx=0;
        for(int i=0; i<inorder.size(); i++)
        {
            map[inorder[i]]=i;
        }
        return helper(0,inorder.size()-1);
    }
    TreeNode* helper(int left, int right)
    {
        if(left>right)
            return NULL;
        int rootval=postorder[postidx];
        TreeNode* root=new TreeNode(rootval);
        int index=map[rootval];
        postidx--;
        root->right=helper(index+1,right);
        root->left=helper(left,index-1);
        return root;
        
    }
};
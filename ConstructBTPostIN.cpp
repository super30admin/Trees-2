//construc BinaryTree 
//we can apply the same approach as preoreder and inorder the change will be
// as we are following the postorder we need to add right branch first

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
    int index;
private:
    TreeNode* helper(vector<int>& postorder,unordered_map<int,int>&inTracker,int left, int right)
    {
        if(left >right)
            return NULL;
        

        TreeNode* new_node = new TreeNode(postorder[index--]);

        new_node->right = helper(postorder,inTracker,inTracker[new_node->val]+1,right);
        new_node->left = helper(postorder,inTracker,left,inTracker[new_node->val]-1);
       
        return new_node;
        
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int,int>inTracker;
        index = postorder.size()-1;
        for(int i = 0;i<inorder.size();i++)
        {
            inTracker[inorder[i]] = i;
        }
        return helper(postorder,inTracker,0,postorder.size()-1);
    }
};
//Time complexity O(N)
//Space complexity O(M) + O(N)/O(log N)
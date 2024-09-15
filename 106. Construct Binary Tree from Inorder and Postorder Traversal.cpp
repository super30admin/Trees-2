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
/*
Time Complexity = O(N*N)
Space Complexity = O(N*N)
where N is the number of the nodes in the tree.
*/
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.empty() || postorder.size()==0)
            return NULL;
        int index, i;
        TreeNode* root = new TreeNode(postorder[postorder.size()-1]);
        for(i=0;i<inorder.size();i++)
        {
            if(postorder[postorder.size()-1]==inorder[i])
            {
                index=i;
                break;
            }
        }
        vector<int> inorderLeft, inorderRight, postorderLeft, postorderRight;
        for(int i=0; i<index; i++){
            inorderLeft.push_back(inorder[i]);
        }
        for(int i=index+1; i<inorder.size(); i++){
            inorderRight.push_back(inorder[i]);
        }
        for(int i=0; i<index; i++){
            postorderLeft.push_back(postorder[i]);
        }
        for(int i=index; i<postorder.size()-1; i++){
            postorderRight.push_back(postorder[i]);
        }
        root->left = buildTree(inorderLeft,postorderLeft);
        root->right = buildTree(inorderRight,postorderRight);
        return root;
    }
};

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
/*
Time Complexity = O(N)
Space Complexity = O(N)
where N is the number of the nodes in the tree.
*/
class Solution {
public:
    map<int, int> m;
    int idx;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.empty() || postorder.size() == 0){
            return NULL;
        }
        idx=postorder.size()-1;
        for(int i=0; i<inorder.size(); i++){
            m[inorder[i]] = i;
        }
        return helper(inorder, postorder, 0, inorder.size()-1);
    }
    TreeNode* helper(vector<int>& inorder, vector<int>& postorder, int start, int end){
        if(start>end)
            return NULL;
        

        //logic
        int rootVal = postorder[idx];
        idx--;
        TreeNode* root = new TreeNode(rootVal);
        int rootIdx = m[rootVal];
        root->right = helper(inorder, postorder, rootIdx+1, end);
        root->left = helper(inorder, postorder,start, rootIdx-1);
        return root;
    }
};

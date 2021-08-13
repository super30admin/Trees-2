// Time Complexity : O(N) where N is the number of nodes.
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    unordered_map<int, int> map;
    int idx=0;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || preorder.size() == 0){
            return NULL;
        }
        for(int i=0; i<inorder.size(); i++){
            map[inorder[i]] = i;
        }
        return helper(preorder, inorder, 0, inorder.size()-1);
    }
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int start, int end){
        if(start>end)
            return NULL;
        
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode* root = new TreeNode(rootVal);
        auto rootIdx = map.find(rootVal);
        root->left = helper(preorder, inorder, start, rootIdx->second-1);
        root->right = helper(preorder, inorder, rootIdx->second+1, end);
        return root;
    }
};



// Time Complexity : O(N*N) where N is the number of nodes.
// Space Complexity :O(H*N) where h is the number of levels of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || preorder.size() == 0){
            return NULL;
        }
        int rootVal = preorder[0];
        TreeNode* root = new TreeNode(rootVal);
        int index = -1;
        for(int i=0; i<inorder.size(); i++){
            if(rootVal == inorder[i]){
                index = i;
                break;
            }
        }
        vector<int> inorderLeft, inorderRight, preorderLeft, preorderRight;
        for(int i=0; i<index; i++){
            inorderLeft.push_back(inorder[i]);
        }
        for(int i=index+1; i<inorder.size(); i++){
            inorderRight.push_back(inorder[i]);
        }
        for(int i=1; i<index+1; i++){
            preorderLeft.push_back(preorder[i]);
        }
        for(int i=index+1; i<preorder.size(); i++){
            preorderRight.push_back(preorder[i]);
        }
        //copy(inorder.begin(), inorder.begin()+2, inorderLeft.begin());
        root->left = buildTree(preorderLeft, inorderLeft);
        root->right = buildTree(preorderRight, inorderRight);
        return root;
    }
};


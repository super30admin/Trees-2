

106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.


TC O(n)
SC O(n)


class Solution {
public:
    void createMapping(vector<int>& inorder, map<int,int>& nodeToIndex, int size) {
        for(int i = 0; i < size; i++) {
            nodeToIndex[inorder[i]]=i;
        }
    }
    
    TreeNode* build(vector<int>& inorder, vector<int>& postorder, int &index, int inOrderStart, int inOrderEnd, int n, map<int,int>& nodeToIndex) {
        //base case;
        if(index < 0 || inOrderStart > inOrderEnd) return NULL;

        int element = postorder[index--];
        TreeNode* root = new TreeNode(element);
        int position = nodeToIndex[element];

        root->right = build(inorder, postorder, index, position+1, inOrderEnd, n, nodeToIndex);
        root->left = build(inorder, postorder, index, inOrderStart, position-1, n, nodeToIndex);
        return root;   
    }
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n = inorder.size();
        int postOrderIndex = n - 1;

        map<int, int> nodeToIndex;
        createMapping(inorder, nodeToIndex, n);
        
        TreeNode* ans = build(inorder, postorder, postOrderIndex, 0, n-1, n, nodeToIndex);
        return ans;
    }
};

// Time Complexity: O(n)
// Space Complexity: Size of Recursive Stack (height of the tree)

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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int,int> inorder_map; 
        for(int i = 0; i < inorder.size(); i++) {
            inorder_map[inorder[i]] = i; 
        }

        TreeNode* head = buildSubTree(inorder_map, inorder, postorder, 0, inorder.size()-1, 0, postorder.size()-1);

        return head; 
    }

    TreeNode* buildSubTree(unordered_map<int,int>& inorder_map, vector<int>& inorder, vector<int>& postorder, int inorder_start, int inorder_end, int postorder_start, int postorder_end) {
        //base
        if(inorder_start > inorder_end || postorder_start > postorder_end) return nullptr;  


        //logic
        TreeNode* node = new TreeNode(postorder[postorder_end]);
        int inorder_index_node = inorder_map[postorder[postorder_end]];
        int number_of_right_children = inorder_end - inorder_index_node; 
        int number_of_left_children = inorder_index_node - inorder_start; 

        int new_inorder_start_right = inorder_index_node + 1;   
        int new_inorder_end_right = inorder_index_node + number_of_right_children; 

        int new_inorder_start_left = inorder_index_node - number_of_left_children; 
        int new_inorder_end_left =  inorder_index_node - 1; 

        int new_postorder_start_right = postorder_end - number_of_right_children;  
        int new_postorder_end_right = postorder_end-1; 

        int new_postorder_end_left = new_postorder_start_right - 1; 
        int new_postorder_start_left =  new_postorder_end_left - number_of_left_children; 

        TreeNode* LST = buildSubTree(inorder_map, inorder, postorder, new_inorder_start_left, new_inorder_end_left, new_postorder_start_left, new_postorder_end_left);
        TreeNode* RST = buildSubTree(inorder_map, inorder, postorder, new_inorder_start_right, new_inorder_end_right, new_postorder_start_right, new_postorder_end_right);

        node->left = LST; 
        node->right = RST; 

        return node; 
    }
};
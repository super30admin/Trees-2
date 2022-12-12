//Time Complexity : O(N) , N is your number of nodes of tree
// Space Complexity : O(H) , H is height of tree

class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.size() == 0 || inorder.size() == 0) return NULL;
        int root_val = postorder[postorder.size() - 1] ;  
        cout << root_val << endl ; 
        TreeNode *root  = new TreeNode(root_val) ;
        int root_index ; 
        vector<int>inorder_left,inorder_right,postorder_left,postorder_right ;

        for(int i = 0 ; i < inorder.size() ; i ++){
            if(inorder[i] == root_val){
                root_index = i ; 
            }
        }

        //define sub vectors

        for(int i = 0 ; i < root_index ; i ++){
            inorder_left.push_back(inorder[i]) ; 
        }

        for(int i = root_index + 1 ; i < inorder.size() ; i ++){
            inorder_right.push_back(inorder[i]) ; 
        }

        for(int i = 0 ; i < inorder_left.size() ; i ++){
            postorder_left.push_back(postorder[i]) ; 
        }

        for(int i = inorder_left.size() ; i < postorder.size() - 1 ; i ++){
            postorder_right.push_back(postorder[i]) ; 
        }

        root->left = buildTree(inorder_left,postorder_left) ; 
        root->right = buildTree(inorder_right,postorder_right) ; 

        return root ; 
    }
};

//Time complexity - O(n)
//Space complexity - O(n)

class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size()==0) return NULL;
        stack<TreeNode*> st;
        int i = inorder.size()-1, p = postorder.size()-1;
        TreeNode *root = new TreeNode(postorder[p--]), *ret = root;
        st.push(root);
        
        while(p>=0 && i>=0){
            if(st.top()->val != inorder[i]){
                root->right = new TreeNode(postorder[p--]);
                root = root->right;
                st.push(root);
            }else{
                while(!st.empty() && st.top()->val == inorder[i]){
                    root = st.top();
                    st.pop();
                    i--;
                }

                root->left = new TreeNode(postorder[p--]);
                root = root->left;
                st.push(root); 
            }
        }
        
    return  ret;
        
    }
};
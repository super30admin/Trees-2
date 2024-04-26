 //Time O(n)
 //Space O(n)
 //leetcode yes
 //Issue seen :none
class Solution {
public:
    int preIdx = 0 ;
    unordered_map<int,int> mp;
    TreeNode* dfs(vector<int>& postorder, int start, int end){
        if(start > end){
            return NULL;
        }

        TreeNode* node = new TreeNode();
        node->val = postorder[preIdx];
        preIdx--;
        int split_idx = mp[node->val];
         
         node->right = dfs(postorder, split_idx+1, end);
        
        node->left = dfs(postorder, start, split_idx-1);
       
        return node;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
         for(int i =0; i<inorder.size(); i++){
            mp[inorder[i]] = i;
        }
        preIdx = postorder.size()-1;
        return dfs(postorder, 0, inorder.size()-1);
    }
};

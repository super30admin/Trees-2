#define l1 long long
class Solution {
public:
   //TC-O(N)
    //SC-O(H)
    l1 ans=0;
    void dfs(TreeNode *root,int value){
        if(!root)return;
      value=(value*10)+root->val;
        
        if(!root->left&&!root->right){
            ans+=value;
            return;
        }
        dfs(root->left,value);
        dfs(root->right,value);
    }
    int sumNumbers(TreeNode* root) {
        if(!root)return 0;
        
        dfs(root,0);
        return ans;
}
};

static int fastio = []() {
    #define endl '\n'
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(0);
    return 0;
}();